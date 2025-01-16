package com.example.myapplication.allCatergories

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class CategoryAdapter(private val categories: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imageItem)
        val text: TextView = itemView.findViewById(R.id.name_item)
        val label: TextView = itemView.findViewById(R.id.labelNew)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item2, parent, false)
        return CategoryViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.image.setImageResource(category.imageRes)
        holder.text.text = category.name
        if (categories[position].label == null){
            holder.label.visibility = View.GONE
        }else{
            when(categories[position].label){
                "NEW" ->{
                    holder.label.setBackgroundResource(R.drawable.label_background)
                    holder.label.text = "NEW"
                }
                "FAVS" ->{
                    holder.label.setBackgroundResource(R.drawable.label_background2)
                    holder.label.text = "FAVS"
                }
            }
        }
    }

    override fun getItemCount() = categories.size
}
