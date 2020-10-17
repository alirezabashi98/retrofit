package com.arb.retrofit.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arb.retrofit.R
import com.arb.retrofit.dataClass.Users
import com.arb.retrofit.fullScreen

class AdapterRecyclerView(private val data: List<Users>) :
    RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val name = view.findViewById<TextView>(R.id.tv_item_users_name)
        val id = view.findViewById<TextView>(R.id.tv_item_users_id)

    }

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_users, null))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.name.text = data[position].name
        holder.id.text = data[position].id.toString()

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, fullScreen::class.java)
            intent.putExtra("id", data[position].id)
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = data.size

}