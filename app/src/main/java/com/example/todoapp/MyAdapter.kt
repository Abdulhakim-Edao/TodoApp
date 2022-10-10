package com.example.todoapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.task_items.view.*

class MyAdapter(var context:Context, var text1: ArrayList<Task>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view =LayoutInflater.from(parent?.context).inflate(R.layout.task_items, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.layout.apply {
            checkbox.text = text1[position].header.toString()
            editText.text = text1[position].body.toString()
        }

        holder.itemView.layout.setOnClickListener{
            val intent = Intent(context, TaskEdit::class.java)
            intent.putExtra("header", text1[position].header)
            intent.putExtra("body", text1[position].body)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return text1.size
    }
}