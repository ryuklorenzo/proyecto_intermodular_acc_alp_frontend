package acc.alp.logged.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


object FuncionesAPI {
    //url
    // funcion de la conexion
    //funcioon de validar login
    private const val URL = "http://localhost/8000"

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
    }

    suspend fun validarLogin(login: Login_request): Login_response {
        return try {
            client.post("$URL/users/login/") {
                contentType(ContentType.Application.FormUrlEncoded)
                setBody(login)
            }.body()
        } catch (e: Exception) {
            throw Exception("Error en el login: ${e.message}")
        }
    }

}