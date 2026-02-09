package acc.alp.logged.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import acc.alp.logged.api.Login_response
import acc.alp.logged.api.Login_request

class LoginAdministradorViewModel: ViewModel(){
    private val _loginSuccess = MutableStateFlow(false)
    val loginSuccess: StateFlow<Boolean> = _loginSuccess
    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun validateLogin(user: String, pass: String) {
        //aqui quiero cambiar esta validacion por la funcion de validar login de funciones API
        if (user == "mate" && pass == "mate") {
            _loginSuccess.value = true
            _errorMessage.value = null
        } else {
            _errorMessage.value = "Usuario o contraseña incorrectos"
        }
    }

    fun resetState() {
        _loginSuccess.value = false
        _errorMessage.value = null
    }
}