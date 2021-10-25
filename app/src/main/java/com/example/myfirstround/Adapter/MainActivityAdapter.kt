package com.example.myfirstround.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstround.Model.Item
import com.example.myfirstround.R
import kotlinx.android.synthetic.main.recycleview.view.*

class MainActivityAdapter(val getAPI:List<Item>): RecyclerView.Adapter<MainActivityAdapter.MyViewAdapter>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewAdapter {
        return MyViewAdapter(LayoutInflater.from(parent.context).inflate(R.layout.recycleview,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewAdapter, position: Int) {
        holder.bind(getAPI[position])
    }

    override fun getItemCount(): Int {
        return getAPI.size
    }

    inner class MyViewAdapter(items: View):RecyclerView.ViewHolder(items){
        fun bind(apis: Item){
            itemView.textView.text = apis.title
        }
    }
}