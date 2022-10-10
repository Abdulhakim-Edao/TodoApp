package com.example.todoapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_task_details.*

class MainActivity : AppCompatActivity() {
    var tasks = ArrayList<Task>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState!=null){
            tasks = savedInstanceState.getSerializable("tasks") as ArrayList<Task>
        }
        tasks.add(Task("Study", "Study mob dev"))
        tasks.add(Task("Study", "Study mob dev"))
        tasks.add(Task("Study", "Study mob dev"))
        tasks.add(Task("Study", "Study mob dev"))
        tasks.add(Task("Study", "Study mob dev"))
        // populate Task

        val resContext = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            if(result.resultCode == Activity.RESULT_OK){
                val body = result.data?.getStringExtra("body")
                val header = result.data?.getStringExtra("header")
                var tsk = Task(header.toString(), body.toString())
                tasks.add(tsk)
            }
        }


        button2.setOnClickListener {
            val myIntent = Intent(this, TaskDetails::class.java)
            resContext.launch(myIntent)
        }


        var myadapter = MyAdapter(this, tasks)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = myadapter

        refresh.setOnClickListener {
            recyclerView.adapter = myadapter
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("tasks", tasks)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        tasks = savedInstanceState.getSerializable("tasks") as ArrayList<Task>
    }
}