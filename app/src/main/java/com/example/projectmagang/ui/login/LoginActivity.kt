package com.example.projectmagang.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.projectmagang.R
import com.example.projectmagang.databinding.ActivityLoginBinding
import com.example.projectmagang.ui.MainActivity
import com.example.projectmagang.ui.register.RegisterActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    private lateinit var viewModel : LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(
            this, ViewModelProvider.NewInstanceFactory()
        )[LoginViewModel::class.java]

        binding.btLogin.setBackgroundResource(R.drawable.edit_text) // Replace with your drawable resource
        binding.tvToRegister.setOnClickListener { startActivity(Intent(this@LoginActivity, RegisterActivity::class.java)) }

        loginUser()
    }

    private fun loginUser(){
        binding.btLogin.setOnClickListener {
            val username = binding.username.text.toString().trim()
            val password = binding.password.text.toString().trim()

            val errorMessages = mutableListOf<String>()

            if (username.isEmpty()){
                errorMessages.add("Please enter a email")
                binding.username.error = "Please enter a username"
            }
            if (password.isEmpty()) {
                errorMessages.add("Please enter a password")
                binding.password.error = "Please enter a password"
            }

            if (errorMessages.isEmpty()) {
                binding.btLogin.isEnabled = false
                viewModel.loginUser(username, password)
            } else {
                val errorMessage = errorMessages.joinToString("\n")
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.LoginResult.observe(this) { result ->
            if (result != null) {
                binding.btLogin.isEnabled = true
                Log.d("pesan", "PESAN : ${result?.username}")
                Log.d("loginHASILID", "User ID: $result.data?.userId")
                Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}