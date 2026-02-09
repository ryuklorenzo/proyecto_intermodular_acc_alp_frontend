package acc.alp.logged.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import acc.alp.logged.api.FuncionesAPI
import acc.alp.logged.api.Login_request

class LoginAdministradorViewModel : ViewModel() {

    private val _loginSuccess = MutableStateFlow(false)
    val loginSuccess: StateFlow<Boolean> = _loginSuccess

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun validateLogin(user: String, pass: String) {
        //corrutina
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                // pedir datos
                val request = Login_request(
                    name = user,
                    password = pass)

                //llamar a api
                val response = FuncionesAPI.validarLogin(request)

                // validar la respuesta
                if (response.accessToken.isNotEmpty()) {
                    _loginSuccess.value = true
                    // Opcional: Guardar el token para futuras peticiones
                    println("Token recibido: ${response.accessToken}")
                } else {
                    _errorMessage.value = "Credenciales incorrectas"
                }

            } catch (e: Exception) {
                e.printStackTrace()
                _errorMessage.value = "Error al iniciar sesión: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun resetState() {
        _loginSuccess.value = false
        _errorMessage.value = null
        _isLoading.value = false
    }
}