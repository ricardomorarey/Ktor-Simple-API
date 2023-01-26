package com.example.routes

import com.bydemes.scc.activities.main.ui.devices.DeviceItem
import com.bydemes.scc.retrofit.response.devicedetail.Data
import com.bydemes.scc.retrofit.response.devicedetail.ResponseDeviceDetail
import com.bydemes.scc.retrofit.response.devices.DataDevices
import com.bydemes.scc.retrofit.response.devices.ResponseDevices
import com.bydemes.tss.retrofit.response.login.*
import com.example.models.Cctv
import com.example.models.PinCodeModel
import com.example.models.Tokens
import com.example.models.User
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private val users = mutableListOf(
    User(1, "Ricardo Gonzalez", 43, "ric@gmail.com"),
    User(2, "Candela Gonzalez", 32, "cande@gmail.com")
)

private val cctvs = mutableListOf(
    Cctv(1111, "Dahua 5000 series")
)

val datadevice1 = DataDevices(
    "Dahua p2p Satprov", "DAH", "p2p", "192.168.2.200",
    "01", "1111", "p37643nkjhkl", "subs111", "video", "Ricardo1", "2347902",
    listOf(1)
)


val datadevice2 = DataDevices(
    "Vesta direct Satprov", "VST", "direct", "192.168.2.220",
    "02", "2222", "3255243564", "subs222", "panel", "Ricardo2", "2347902",
    listOf(1, 2)
)

val datadevice3 = DataDevices(
    "Honeywell direct Satprov", "HON", "direct", "192.168.2.230",
    "03", "3333", "235dfg4325423", "subs333", "fire", "Ricardo3", "2347902",
    listOf(1, 2, 3)
)

val datadevice4 = DataDevices(
    "Hikvision direct oficina", "HIK", "direct", "192.168.2.240",
    "04", "4444", "dfsfrstgrtgs", "subs444", "video", "Ricardo3", "2347902",
    listOf(1, 2, 3, 4)
)

val datadevice5 = DataDevices(
    "Hikvision 2 direct oficina", "HIK", "direct", "192.168.2.250",
    "05", "5555", "dfs3333333frstgdtrtgs", "subs555", "video", "Ricardo3", "2347902",
    listOf(1, 2, 3, 4)
)

val datadevice6 = DataDevices(
    "Hikvision 2 direct oficina", "HIK", "direct", "192.168.2.250",
    "05", "5555", "dfsfrstgd6577trtgs", "subs555", "video", "Ricardo3", "2347902",
    listOf(1, 2, 3, 4)
)

val datadevice7 = DataDevices(
    "Hikvision 2 direct oficina", "HIK", "direct", "192.168.2.250",
    "05", "5555", "dfsfeytrstg'9'9¡dtrtgs", "subs555", "video", "Ricardo3", "2347902",
    listOf(1, 2, 3, 4)
)

val datadevice8 = DataDevices(
    "Hikvision 2 direct oficina", "HIK", "direct", "192.168.2.250",
    "05", "5555", "dfsfrstgdteret97864uhyrtgs", "subs555", "video", "Ricardo3", "2347902",
    listOf(1, 2, 3, 4)
)


var devices = mutableListOf<DataDevices>(
    datadevice1,
    datadevice2,
    datadevice3,
    datadevice4,
    datadevice5,
    datadevice6,
    datadevice7,
    datadevice8
)
var alldevices: ResponseDevices = ResponseDevices(devices, "ok all mockup")


private val tokens = Tokens("TokenAccesMokeadoenKtor", "TokenRefreshMokeadoenKtor")


fun Route.userRouting() {
    route("/user") {
        get {
            if (users.isNotEmpty()) {
                call.respond(users)
            } else {
                call.respondText("No hay usuarios", status = HttpStatusCode.OK)
            }
        }
        get("{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "id no encontrado",
                status = HttpStatusCode.BadRequest
            )
            val user = users.find { it.id == id.toInt() } ?: return@get call.respondText(
                "Usuario con $id no encontrado",
                status = HttpStatusCode.NotFound
            )
            call.respond(user)
        }
        post {
            val user = call.receive<User>()
            users.add(user)
            call.respondText("Usuario creado", status = HttpStatusCode.Created)
        }
        delete("{id?}") {
            val id = call.parameters["id"] ?: return@delete call.respondText(
                "id no encontrado",
                status = HttpStatusCode.BadRequest
            )
            if (users.removeIf({ it.id == id.toInt() })) {
                call.respondText("Usuario eliminado", status = HttpStatusCode.Accepted)
            } else {
                call.respondText("id no encontrado", status = HttpStatusCode.NotFound)
            }
        }
    }
    route("/auth/") {
        get {
            call.respond(tokens)
        }
        post {
            val pincode = call.receive<PinCodeModel>()
            if (pincode.pinCode == "111111") {
                call.respond(LoginResponse(DataLogin("TokenAccesMokeadoenKtor", "TokenRefreshMokeadoenKtor"), "ok"))
            } else {
                call.respond(status = HttpStatusCode.Unauthorized, "Pin code invalid")
            }
        }

    }
    route("/auth/{refresh_jti}/") {

        delete() {
            call.respond(LogoutResponse("logout"))

        }

    }
    route("/devices") {

        get {
            call.respond(alldevices)
            //call.respond(status = HttpStatusCode.InternalServerError, "Pin code invalid")
        }

    }
    route("/devices/{device_uuid}/") {
        get {
            val uuid = call.parameters["device_uuid"] ?: return@get call.respondText(
                "uuid no encontrado",
                status = HttpStatusCode.BadRequest
            )
            val cctv = cctvs.find { it.uuid == uuid.toInt() } ?: return@get call.respondText(
                "Usuario con $uuid no encontrado",
                status = HttpStatusCode.NotFound
            )
            val mycctvdetail = ResponseDeviceDetail(
                Data(
                    "DAH",
                    channels = listOf<Int>(6, 7, 8, 9, 10),
                    "p2p",
                    "Dahua p2p Satprov",
                    "192.168.2.200",
                    "87654321-4321-1234-5678-123456789012",
                    "3333",
                    "236234HHGV232379",
                    "subs1238",
                    "video",
                    "002",
                    "JaneDoe"
                ), "my cctv detail"
            )
            call.respond(mycctvdetail)
        }
    }


}