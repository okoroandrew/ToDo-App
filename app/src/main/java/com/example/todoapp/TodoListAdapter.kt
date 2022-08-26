package com.example.todoapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoListAdapter(private var mTodos: List<String>): RecyclerView.Adapter<TodoListAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val importantFlagButton = itemView.findViewById<Button>(R.id.important_button)
        val importantCheckBox = itemView.findViewById<CheckBox>(R.id.important_checkBox)
        val todoTextView = itemView.findViewById<TextView>(R.id.todo_item_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val todoView = inflater.inflate(R.layout.todo_item, parent, false)
        return ViewHolder(todoView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todo = mTodos[position]

        val importantFlag = R.string.important_flag.toString()
        val lengthFlag = importantFlag.length

        if (todo.contains("iMporTanT")){
            holder.todoTextView.text = todo.dropLast(lengthFlag)
            holder.importantFlagButton.setBackgroundColor(Color.GREEN)
        }
        else{
            holder.todoTextView.text = todo
            holder.importantFlagButton.setBackgroundColor(Color.BLUE)
        }

    }

    override fun getItemCount(): Int {
        return mTodos.size
    }


}

