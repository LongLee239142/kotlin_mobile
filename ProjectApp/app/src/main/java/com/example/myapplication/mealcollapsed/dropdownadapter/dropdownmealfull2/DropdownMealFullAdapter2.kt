package com.example.myapplication.mealcollapsed.dropdownadapter.dropdownmealfull2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class DropdownMealFullAdapter2(private val items: List<DataSourceDropdown2>):
RecyclerView.Adapter<DropdownMealFullAdapter2.ViewHolder>(){
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageProduct: ImageView = itemView.findViewById(R.id.imageProduct)
        val textView: TextView = itemView.findViewById(R.id.titleProduct)
        val imageView: ImageView = itemView.findViewById(R.id.chevronImageView)
        val textEdit: TextView = itemView.findViewById(R.id.editTextView)

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DropdownMealFullAdapter2.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dropdow_meal_full2, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DropdownMealFullAdapter2.ViewHolder, position: Int) {
        var item = items[position]

        // Thiết lập hình ảnh sản phẩm
        holder.imageProduct.setImageResource(item.imageProduct)

        // Thiết lập tên sản phẩm
        holder.textView.text = item.tilteName
        holder.imageView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "You want to edit ?", Toast.LENGTH_SHORT).show()
        }
        holder.textEdit.setOnClickListener {
            Toast.makeText(holder.itemView.context, "You want to edit ?", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount() = items.size
}