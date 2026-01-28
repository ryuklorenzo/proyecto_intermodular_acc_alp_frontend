package acc.alp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AppViewModel: ViewModel(){

    private val _darkMode = MutableStateFlow<Boolean>(false)
    val darkMode: StateFlow<Boolean> = _darkMode.asStateFlow()

    fun setDarkMode(){
        _darkMode.value=true;
    }
    fun setLighMode(){
        _darkMode.value=false;
    }
    fun swithMode(){
        _darkMode.value=!_darkMode.value;
    }

}