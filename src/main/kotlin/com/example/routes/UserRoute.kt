package com.example.routes

import com.example.models.*
import com.example.models.devicedetail.Data
import com.example.models.devicedetail.ResponseDeviceDetail
import com.example.models.devices.DataDevices
import com.example.models.devices.ResponseDevices
import com.example.models.eventlist.DataNotifications
import com.example.models.eventlist.ResponseEventList
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
    Cctv("1111", "Dahua 5000 series")
)

val datadevice1 = DataDevices(
    "ADahua p2p Satprov", "DAH", "p2p", "190.168.2.200",
    "01", "1111", "p37643nkjhkl", "subs111", "video", "Ricardo1", "1111",
    listOf(1)
)


val datadevice2 = DataDevices(
    "BVesta direct ", "VST", "direct", "191.168.2.220",
    "02", "2222", "3255243564", "subs222", "panel", "Ricardo2", "2347902",
    listOf(1, 2)
)

val datadevice3 = DataDevices(
    "CHoneywell direct Satprov", "HON", "direct", "192.168.2.230",
    "03", "3333", "235dfg4325423", "subs333", "fire", "Ricardo3", "2347902",
    listOf(1, 2, 3)
)

val datadevice4 = DataDevices(
    "DHikvision direct oficina", "HIK", "direct", "193.168.2.240",
    "04", "4444", "dfsfrstgrtgs", "subs444", "video", "Ricardo4", "2347902",
    listOf(1, 2, 3, 4)
)

val datadevice5 = DataDevices(
    "EDahua 2 direct casa", "DAH", "direct", "194.168.2.250",
    "05", "5555", "dfs3333333frstgdtrtgs", "subs555", "video", "Ricardo5", "2347902",
    listOf(1, 2, 3, 4)
)

val datadevice6 = DataDevices(
    "FVestas 2 direct oficina", "VST", "direct", "195.168.2.252",
    "05", "5555", "dfsfrstgd6577trtgs", "subs555", "panel", "Ricardo6", "2347902",
    listOf(1, 2, 3, 4)
)

val datadevice7 = DataDevices(
    "GHikvision direct oficina2", "HIK", "direct", "196.168.2.250",
    "05", "5555", "dfsfeytrstg'9'9¡dtrtgs", "subs555", "video", "Ricardo7", "2347902",
    listOf(1, 2, 3, 4)
)

val datadevice8 = DataDevices(
    "HHoneywell 334 oficina", "HON", "direct", "197.168.2.270",
    "05", "5555", "dfsfrstgdteret97864uhyrtgs", "subs555", "fire", "Ricardo8", "2347902",
    listOf(1, 2, 3, 4)
)


val devicePushList1 = com.example.models.devicespushlist.Data("2022-01-01T10:00:00", true, "1111")
val devicePushList2 = com.example.models.devicespushlist.Data("2022-01-01T10:00:00", false, "2222")
val devicePushList3 = com.example.models.devicespushlist.Data("2022-01-01T10:00:00", true, "3333")
val devicePushList4 = com.example.models.devicespushlist.Data("2022-01-01T10:00:00", false, "4444")
val devicePushList5 = com.example.models.devicespushlist.Data("2022-01-01T10:00:00", true, "5555")
val devicePushList6 = com.example.models.devicespushlist.Data("2022-01-01T10:00:00", false, "6666")
val devicePushList7 = com.example.models.devicespushlist.Data("2022-01-01T10:00:00", true, "7777")
val devicePushList8 = com.example.models.devicespushlist.Data("2022-01-01T10:00:00", false, "8888")
var devicePushList = listOf<com.example.models.devicespushlist.Data>(
    devicePushList1,
    devicePushList2,
    devicePushList3,
    devicePushList4,
    devicePushList5,
    devicePushList6,
    devicePushList7,
    devicePushList8
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
val notification1 = DataNotifications("DHA", "22/01/2023", "dahua 1",
    "1111", "video", 1, "001")
val notification11 = DataNotifications("DHA", "21/01/2023", "dahua 1.1",
    "1111", "panel", 8, "023")
val notification2 = DataNotifications("HON", "31/01/2023", "honeywell 2",
    "2222", "fire", 2, "002")
val notification3 = DataNotifications("HIK", "30/01/2023", "hikvision 3",
    "3333", "video", 3, "003")
val notification4 = DataNotifications("VST", "19/01/2023", "vesta 4",
    "4444", "panel", 4, "004")
val notification5 = DataNotifications("DHA", "12/01/2023", "dahua 5",
    "5555", "video", 5, "005")
val notification6 = DataNotifications("HIK", "1/01/2023", "hikvision 6",
    "6666", "video", 6, "006")
val notification7 = DataNotifications("HON", "28/01/2023", "honeywell 7",
    "7777", "fire", 7, "007")
var notifications = mutableListOf<DataNotifications>(
    notification1,
    notification11,
    notification2,
    notification3,
    notification4,
    notification5,
    notification6,
    notification7
)

var allNotifications : ResponseEventList = ResponseEventList(notifications, "ok all mockup")

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
            //call.respond("{\"status\":\"success\",\"data\":[{\"description\":\"MASTER_BYDEMES\",\"uuid\":\"87654321-4321-1234-5678-123456789012\",\"brand\":\"MASTER_BYDEMES\",\"type\":\"DAH\",\"subs\":\"0000\",\"connectionType\":\"normal\",\"host\":\"0\",\"port\":\"0\",\"sn\":\"MASTER_SERIAL\",\"id\":\"1\",\"channels\":[1,2,3,4],\"user\":\"MASTER_US\"},{\"description\":\"ColEvoIpPrb\",\"uuid\":\"87654321-4321-1234-5678-123456789012\",\"brand\":\"ColEvoIpPrb\",\"type\":\"DAH\",\"subs\":\"9999\",\"connectionType\":\"p2p\",\"host\":\"192.168.0.5\",\"port\":\"0\",\"sn\":\"4C036BBPAZF500B\",\"id\":\"4\",\"channels\":[1,2,3,4],\"user\":\"admin\"}]}")
        }

    }
    route("/devices/{device_uuid}/") {
        get {
            val uuid = call.parameters["device_uuid"] ?: return@get call.respondText(
                "uuid no encontrado",
                status = HttpStatusCode.BadRequest
            )
            val cctv = cctvs.find { it.uuid == uuid } ?: return@get call.respondText(
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
                    "02",
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
    route("/events/") {

        get {
            call.respond(allNotifications)
        }

    }
    route("/devices/settings/") {

        get {
            call.respond(devicePushList)
        }

    }



}