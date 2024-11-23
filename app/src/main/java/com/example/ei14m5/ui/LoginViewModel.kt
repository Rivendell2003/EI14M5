package com.example.ei14m5.ui

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    // use un  LiveData para el estado del login
    val loginSuccess = MutableLiveData<Boolean>()

    private val sharedPreferences = application.getSharedPreferences("loginPrefs", Context.MODE_PRIVATE)

    // la fun para validar el login
    fun validateLogin(email: String, password: String, rememberMe: Boolean) {
        // la logic de validación (simulada por ahora)
        val isValid = email == "user@example.com" && password == "password123"

        if (isValid) {
            loginSuccess.value = true

            // aca si Si 'rememberMe' está activado, guardamos la información en SharedPreferences
            if (rememberMe) {
                sharedPreferences.edit().putBoolean("rememberMe", true).apply()
                sharedPreferences.edit().putString("savedEmail", email).apply()
            } else {
                // aca si  el 'rememberMe' no está activado, eliminamos la información
                sharedPreferences.edit().clear().apply()
            }
        } else {
            loginSuccess.value = false
        }
    }

    // la fun  para verificar si el usuario ha marcado "Recordar sesión"
    fun isUserRemembered(): Boolean {
        return sharedPreferences.getBoolean("rememberMe", false)
    }

    // la fun para obtener el email guardado
    fun getSavedEmail(): String? {
        return sharedPreferences.getString("savedEmail", "")
    }
}
