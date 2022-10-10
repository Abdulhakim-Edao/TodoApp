package com.example.todoapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_task_details.*

class TaskDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_details)

        addButton.setOnClickListener {
            val intent = intent
            val body = body.text.toString()
            val header = header.text.toString()
            intent.putExtra("header", header)
            intent.putExtra("body", body)
            if(header.isNotEmpty() && body.isNotEmpty()){
                setResult(Activity.RESULT_OK, intent)
                finish()
            }

        }
    }
}