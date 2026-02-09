package acc.alp.logged.api


data class Login_request(
    val name: String,
    val password: String

)
data class Login_response(
    val name: String? = null,
    val password: String? = null
)