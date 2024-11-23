package com.example.ei14m5.util


object ValidationUtils {
    fun isValidEmail(email: String): Boolean {
        return email.contains("@")
    }

    fun isValidPassword(password: String): Boolean {
        return password.length >= 6
    }
}
