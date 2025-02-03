package com.example.myapplication.homepage.newtrending

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R


class DataNewTrendingAdapter(private val newTrending: List<DataNewTrending>):
RecyclerView.Adapter<DataNewTrendingAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageTile: ImageView = itemView.findViewById(R.id.imageCover)
        val textTile: TextView = itemView.findViewById(R.id.textTitle)
        val textDes: TextView = itemView.findViewById(R.id.textDescription)
        val imageLogo: ImageView = itemView.findViewById(R.id.imageLogo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_items_new_trending, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listNewtrending = newTrending[position]
        holder.imageTile.setImageResource(listNewtrending.imageCover)
        holder.imageLogo.setImageResource(listNewtrending.imageLogo)
        holder.textDes.text = listNewtrending.description
        holder.textTile.text = listNewtrending.title
    }

    override fun getItemCount() = newTrending.size
}