package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_task_edit.*

class TaskEdit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_edit)

        var intent = intent
        var bodyy = intent.getStringExtra("body")
        var headerh = intent.getStringExtra("header")
        header.text = headerh.toString()
        body.text = bodyy.toString()
    }
}