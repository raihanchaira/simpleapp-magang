package com.example.projectmagang.ui.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.projectmagang.R
import com.example.projectmagang.databinding.ActivityAddUserBinding
import com.example.projectmagang.ui.register.RegisterViewModel

class AddUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddUserBinding
    private lateinit var viewModel : RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUserBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(
            this, ViewModelProvider.NewInstanceFactory()
        )[RegisterViewModel::class.java]

        binding.btSubmit.setOnClickListener {
            val username = binding.username.text.toString().trim()
            val password = binding.password.text.toString().trim()
            val name = binding.name.text.toString().trim()
            val email = binding.email.text.toString().trim()

            addUser(username, password, name, email)
        }
    }

    private fun addUser(username: String, password: String, name: String, email: String) {
        val errorMessages = mutableListOf<String>()

        if (username.isEmpty()) {
            errorMessages.add("Please enter a username")
            binding.username.error = "Please enter a username"
        }

        if (password.isEmpty()) {
            errorMessages.add("Please enter a password")
            binding.password.error = "Please enter a password"
        }

        if (name.isEmpty()) {
            errorMessages.add("Please enter your name")
            binding.name.error = "Please enter your name"
        }

        if (email.isEmpty()) {
            errorMessages.add("Please enter an email")
            binding.email.error = "Please enter an email"
        }

        if (errorMessages.isEmpty()) {
            binding.btSubmit.isEnabled = false
            viewModel.registerUser(username, password, name, email)
        } else {
            val errorMessage = errorMessages.joinToString("\n")
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        }
    }

}