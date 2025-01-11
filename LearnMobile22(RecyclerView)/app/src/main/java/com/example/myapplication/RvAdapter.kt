package com.example.myapplication

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RvAdapter(private val activity: Activity, private var ds: List<OutData>) :
    RecyclerView.Adapter<RvAdapter.MovieViewHolder>() {

    // Class ViewHolder
    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val images: ImageView = itemView.findViewById(R.id.imgMovie)
        val txtDescription: TextView = itemView.findViewById(R.id.txtDescription)
        val txtName: TextView = itemView.findViewById(R.id.txtMovie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val data = ds[position]
        Log.d("RvAdapter", "Binding item at position: $position with data: $data")
        holder.images.setImageResource(data.images)
        holder.txtName.text = data.nameMovie
        holder.txtDescription.text = data.description
    }

    override fun getItemCount(): Int {
        return ds.size
    }
}
