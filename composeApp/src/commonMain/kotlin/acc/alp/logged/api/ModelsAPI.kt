package acc.alp.logged.api


data class login_request(
    val name: String,
    val password: String

)
data class login_response(
    val name: String? = null,
    val password: String? = null
)