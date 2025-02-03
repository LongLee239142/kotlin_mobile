package com.example.myapplication.mealcollapsed.dropdownadapter.dropdownmealfull2

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class DropdownMealFullAdapter2_1(private val items: List<DataSourceDropdown2_1>) :
    RecyclerView.Adapter<DropdownMealFullAdapter2_1.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageProduct: ImageView = itemView.findViewById(R.id.imageProduct)
        val textView: TextView = itemView.findViewById(R.id.titleProduct)
        val quantity: TextView = itemView.findViewById(R.id.quantityText)
        val imageViewPlus: ImageView = itemView.findViewById(R.id.addButton)
        val imageViewSubtract: ImageView = itemView.findViewById(R.id.subtractButton)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DropdownMealFullAdapter2_1.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dropdow_meal_full2_1, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = items[position]

        holder.imageProduct.setImageResource(item.imageProduct)
        holder.textView.text = item.tilteName
        holder.quantity.text = item.quantity

        holder.imageViewPlus.setOnClickListener {
            holder.quantity.text = (holder.quantity.text.toString().toInt() + 1).toString()
        }
        holder.imageViewSubtract.setOnClickListener {
            val tempQuantity = holder.quantity.text.toString().toInt() - 1
            if (tempQuantity > 0)
                holder.quantity.text = tempQuantity.toString()
            else
                holder.quantity.text = "0"
        }
    }


    override fun getItemCount() = items.size
}