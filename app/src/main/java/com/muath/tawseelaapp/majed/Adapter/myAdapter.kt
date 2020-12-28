package com.muath.tawseelaapp.majed.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.muath.tawseelaapp.R
import com.muath.tawseelaapp.majed.models.Request
import kotlinx.android.synthetic.main.grid_item.view.*

class myAdapter (
    var activity: FragmentActivity, var data: ArrayList<Request>) :
    RecyclerView.Adapter<myAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.tv_name
        val pris = itemView.pris
        val time = itemView.time
        val date = itemView.date



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val root = LayoutInflater.from(activity).inflate(R.layout.grid_item, parent, false)
        return MyViewHolder(root)    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvName.text  =data[position].nameRequest
        holder.pris.text=data[position].prise.toString()
        holder.time.text=data[position].time
        holder.date.text=data[position].day


    }
}