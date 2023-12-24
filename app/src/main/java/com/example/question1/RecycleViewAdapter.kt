package com.example.question1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RecycleViewAdapter(
    private val context: Context,
    private val dataList: ArrayList<ResponseModel>
) : RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder>() {

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvFname = view.findViewById<TextView>(R.id.tv_fname)
        val tvLname = view.findViewById<TextView>(R.id.tv_lname)
        val tvEmail = view.findViewById<TextView>(R.id.tv_email)
        val cvMain = view.findViewById<CardView>(R.id.cv_main)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.items_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvFname.text = dataList[position].first_name
        holder.tvLname.text = dataList[position].last_name
        holder.tvEmail.text = dataList[position].email
        holder.cvMain.setOnClickListener {
            Toast.makeText(context, "" + dataList[position].first_name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = dataList.size

    fun setData(data: ArrayList<ResponseModel>) {
        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()
    }
}
