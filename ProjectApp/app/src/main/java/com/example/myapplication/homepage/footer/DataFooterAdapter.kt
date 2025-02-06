package com.example.myapplication.homepage.footer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class DataFooterAdapter(private val newTrending: List<DataFooter>):
    RecyclerView.Adapter<DataFooterAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageTile: ImageView = itemView.findViewById(R.id.imageTitle)
        val textDes: TextView = itemView.findViewById(R.id.textDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_items_footer, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listNewtrending = newTrending[position]
        holder.imageTile.setImageResource(listNewtrending.imageTitle)
        holder.textDes.text = listNewtrending.description
    }

    override fun getItemCount() = newTrending.size
}