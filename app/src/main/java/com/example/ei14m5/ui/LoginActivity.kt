package com.example.ei14m5.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.ei14m5.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (loginViewModel.isUserRemembered()) {
            val savedEmail = loginViewModel.getSavedEmail()
            binding.etEmail.setText(savedEmail)
            binding.cbRememberMe.isChecked = true
        }

        loginViewModel.loginSuccess.observe(this) { success ->
            if (success) {
            } else {
            }
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val rememberMe = binding.cbRememberMe.isChecked

            loginViewModel.validateLogin(email, password, rememberMe)
        }

        binding.tvForgotPassword.setOnClickListener {
            // la logic de "Olvidé mi contraseña"
        }
    }
}
