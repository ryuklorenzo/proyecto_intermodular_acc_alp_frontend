package acc.alp.logged.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Login_request(
    val name: String,
    val password: String

)
@Serializable
data class Login_response(
    @SerialName("access_token") val accessToken: String,
    @SerialName("token_type") val tokenType: String
)