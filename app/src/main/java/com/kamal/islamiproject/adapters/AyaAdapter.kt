package com.example.islami.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kamal.islamiproject.R
import kotlinx.android.synthetic.main.item_aya.view.*

class AyaAdapter(var items:List<String>):RecyclerView.Adapter<AyaAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_aya,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val aya = items.get(position)
        holder.aya.setText(aya+" {"+(position+1)+"}")
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        val aya = itemView.aya_Name
    }
}