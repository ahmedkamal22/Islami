package com.example.islami.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kamal.islamiproject.R
import com.kamal.islamiproject.api.RadiosChannel
import kotlinx.android.synthetic.main.item_sura.view.*
import kotlinx.android.synthetic.main.layout_channel.view.*

class RadiosAdapter(var items:List<RadiosChannel?>?):RecyclerView.Adapter<RadiosAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_channel,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items?.size?:0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var radios = items?.get(position)
        holder.header.setText(radios?.name)
        if(onPlayClickListener!=null)
        {
            holder.play.setOnClickListener {
                onPlayClickListener?.onItemClick(position,radios!!)
            }
        }
        if(onStopClickListener!=null)
        {
            holder.stop.setOnClickListener {
                onStopClickListener?.onItemClick(position,radios!!)
            }
        }
    }
    var onPlayClickListener: onItemClickListener?=null
    var onStopClickListener: onItemClickListener?=null
     interface onItemClickListener{
        fun onItemClick(position: Int,radiosChannels: RadiosChannel)
    }
    fun changeData(items: List<RadiosChannel?>?)
    {
        this.items = items
        notifyDataSetChanged()
    }
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        val header = itemView.sura_Header
        val play = itemView.play
        val stop = itemView.stop
    }
}