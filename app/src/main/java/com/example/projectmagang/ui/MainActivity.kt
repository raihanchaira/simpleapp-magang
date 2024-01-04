package com.example.projectmagang.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectmagang.databinding.ActivityMainBinding
import com.example.projectmagang.ui.dashboard.AddUserActivity
import com.example.projectmagang.ui.dashboard.UserAdapter
import com.example.projectmagang.ui.dashboard.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userAdapter = UserAdapter(null)

        setUpRecyclerView()

        userViewModel.getUserListResult().observe(this) { userList ->
            userList?.let {
                userAdapter.setData(it)
            }
        }
        userViewModel.getUserList()

        binding.fabAdd.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddUserActivity::class.java))
        }
    }

    private fun setUpRecyclerView() {
        binding.rvUser.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvUser.adapter = userAdapter
    }
}



