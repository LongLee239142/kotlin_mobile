package com.example.myapplication.homepage.offernear

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.allCatergories.Category
import com.example.myapplication.allCatergories.CategoryAdapter


class DataNearOfferAdapter(private val listDataNearOffer: List<DataNearOffer>) :
    RecyclerView.Adapter<DataNearOfferAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imageView3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_items_offer_near, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = listDataNearOffer[position]
        holder.image.setImageResource(category.imageRes)
    }

    override fun getItemCount() = listDataNearOffer.size
}