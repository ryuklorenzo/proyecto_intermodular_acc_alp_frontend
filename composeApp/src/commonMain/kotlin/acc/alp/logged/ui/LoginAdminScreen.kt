package acc.alp.logged.ui

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginAdminScreen(
    viewModel: LoginAdministradorViewModel,
    onLoginSuccess: () -> Unit
) {
    //Pantalla para acceder a la app con admin
    var user by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    val loginOK by viewModel.loginSuccess.collectAsState()
    val errorMsg by viewModel.errorMessage.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    if (loginOK) {
        onLoginSuccess()
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Acceso Administrador", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = user,
            onValueChange = { user = it },
            label = { Text("Usuario") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = pass,
            onValueChange = { pass = it },
            label = { Text("Contraseña") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { viewModel.validateLogin(user, pass) },
            enabled = user.isNotBlank() && pass.isNotBlank() && !isLoading
        ) {
            Text("Entrar")
        }
        if (errorMsg != null) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = errorMsg ?: "",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}