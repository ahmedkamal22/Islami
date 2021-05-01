package com.example.islami.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kamal.islamiproject.R
import kotlinx.android.synthetic.main.item_sura.view.*

class SurasAdapter(var items:List<String>):RecyclerView.Adapter<SurasAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sura,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sura = items.get(position)
        holder.suraName.setText(sura)
        if(onSuraClickListener!=null)
        {
            holder.itemView.setOnClickListener {
                onSuraClickListener?.onItemClick(position,sura)
            }
        }
    }
    var onSuraClickListener: onItemClickListener?=null
     interface onItemClickListener{
        fun onItemClick(position: Int,name:String)
    }
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        val suraName = itemView.sura_Name
    }
}