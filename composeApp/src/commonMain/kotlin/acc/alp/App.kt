package acc.alp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import acc.alp.logged.ui.*
import androidx.compose.ui.tooling.preview.Preview

@Suppress("ViewModelConstructorInComposable")
@Composable
@Preview
fun App() {
    // 1. El tema es obligatorio para componentes Material3
    MaterialTheme {
        // 2. IMPORTANTE: Surface proporciona el fondo y el color base para el texto.
        // Sin esto, la pantalla puede verse vacía o negra en Desktop.
        Surface(modifier = Modifier.fillMaxSize()) {

            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = AppRoutes.Loggin
            ) {
                composable(AppRoutes.Loggin) {
                    val loginVM = remember { LoginAdministradorViewModel() }
                    val isLogged by loginVM.loginSuccess.collectAsState()

                    if (!isLogged) {
                        LoginAdminScreen(
                            viewModel = loginVM,
                            onLoginSuccess = {
                                // Lógica extra al loguearse si es necesaria
                            }
                        )
                    } else {
                        // Cuando isLogged es true, se muestra esto.
                        MainAdministrador()
                    }
                }
            }
        }
    }
}