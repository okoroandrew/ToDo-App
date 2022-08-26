package com.example.todoapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todoapp.databinding.ActivityAddToDoBinding

class AddToDoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddToDoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddToDoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener{
            Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show()

            val title = if (binding.importantCheckBox.isChecked){
                binding.addTodoEditTextText.text.toString() + " " + getString(R.string.important_flag)
            }else{
                binding.addTodoEditTextText.text.toString()
            }

            val sharedPreferences = getSharedPreferences("com.example.todoapp.sharedPreferences", Context.MODE_PRIVATE)
            val todos = sharedPreferences.getStringSet("myToDoSet", mutableSetOf())
            todos?.add(title)

            sharedPreferences.edit().putStringSet("myToDoSet", todos).apply()

            finish()
        }

    }
}