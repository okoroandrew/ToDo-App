package com.example.todoapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener{
            startActivity(Intent(this, AddToDoActivity::class.java))
        }

    }

    override fun onResume() {
        super.onResume()

        val sharedPreferences = getSharedPreferences("com.example.todoapp.sharedPreferences", Context.MODE_PRIVATE)
        val todos = sharedPreferences.getStringSet("myToDoSet", mutableSetOf())

        val adapter = todos?.let { TodoListAdapter(it.toList()) }
        binding.todoRecyclerView.adapter = adapter
        binding.todoRecyclerView.layoutManager = LinearLayoutManager(this)
    }


}