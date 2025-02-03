package com.example.myapplication.mealcollapsed.dropdownadapter.dropdownmealfull2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class DropdownMealFullAdapter2_2(private val items: List<DataSourceDropdown2_2>) :
    RecyclerView.Adapter<DropdownMealFullAdapter2_2.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageProduct: ImageView = itemView.findViewById(R.id.imageProduct)
        val textView: TextView = itemView.findViewById(R.id.titleProduct)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DropdownMealFullAdapter2_2.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dropdow_meal_full2_2, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DropdownMealFullAdapter2_2.ViewHolder, position: Int) {
        var item = items[position]
        holder.imageProduct.setImageResource(item.imageProduct)
        holder.textView.text = item.tilteName
    }

    override fun getItemCount() = items.size
}