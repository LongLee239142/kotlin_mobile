package com.example.myapplication.mealcollapsed.dropdownadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.mealcollapsed.dataoutsource.DataSource
import com.example.myapplication.mealcollapsed.dropdownadapter.dropdownmealfull1.DataSourceDropdown1
import com.example.myapplication.mealcollapsed.dropdownadapter.dropdownmealfull1.DataSourceDropdown1_1
import com.example.myapplication.mealcollapsed.dropdownadapter.dropdownmealfull1.DropdownMealFullAdapter1
import com.example.myapplication.mealcollapsed.dropdownadapter.dropdownmealfull1.DropdownMealFullAdapter1_1
import com.example.myapplication.mealcollapsed.dropdownadapter.dropdownmealfull2.DataSourceDropdown2
import com.example.myapplication.mealcollapsed.dropdownadapter.dropdownmealfull2.DataSourceDropdown2_1
import com.example.myapplication.mealcollapsed.dropdownadapter.dropdownmealfull2.DataSourceDropdown2_2
import com.example.myapplication.mealcollapsed.dropdownadapter.dropdownmealfull2.DropdownMealFullAdapter2
import com.example.myapplication.mealcollapsed.dropdownadapter.dropdownmealfull2.DropdownMealFullAdapter2_1
import com.example.myapplication.mealcollapsed.dropdownadapter.dropdownmealfull2.DropdownMealFullAdapter2_2

class DropdownAdapter2(
    private val items: List<DataSource>,
    private val itemsDropdown2: List<DataSourceDropdown2>,
    private val itemsDropdown2_1: List<DataSourceDropdown2_1>? = null,
    private val itemsDropdown2_2: List<DataSourceDropdown2_2>? = null,
) : RecyclerView.Adapter<DropdownAdapter2.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val headerLayout: LinearLayout = itemView.findViewById(R.id.headerLayout2)
        val headerTitle: TextView = itemView.findViewById(R.id.headerTitle2)
        val textView: TextView = itemView.findViewById(R.id.textView2)
        val dropdownLayout: LinearLayout = itemView.findViewById(R.id.dropdownLayout2)
        val buttonPlus: ImageView = itemView.findViewById(R.id.imageView2)
        val recyclerViewDropdown2: RecyclerView =
            itemView.findViewById(R.id.dropdown_menu_meal_full2)
        val recyclerViewDropdown2_1: RecyclerView =
            itemView.findViewById(R.id.dropdown_menu_meal_full2_1)
        val recyclerViewDropdown2_2: RecyclerView =
            itemView.findViewById(R.id.dropdown_menu_meal_full2_2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_meal_collapsed2, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.headerTitle.text = item.tilteName
        holder.textView.text = item.note

        holder.recyclerViewDropdown2.layoutManager =
            LinearLayoutManager(holder.dropdownLayout.context)
        holder.recyclerViewDropdown2.adapter = DropdownMealFullAdapter2(itemsDropdown2)

        holder.recyclerViewDropdown2_1.layoutManager =
            LinearLayoutManager(holder.dropdownLayout.context)
        holder.recyclerViewDropdown2_1.adapter =
            itemsDropdown2_1?.let { DropdownMealFullAdapter2_1(it) }

        holder.recyclerViewDropdown2_2.layoutManager =
            LinearLayoutManager(holder.dropdownLayout.context)
        holder.recyclerViewDropdown2_2.adapter =
            itemsDropdown2_2?.let { DropdownMealFullAdapter2_2(it) }
//
//         Xử lý sự kiện click để hiện/ẩn dropdown
        holder.headerLayout.setOnClickListener {
            if (holder.dropdownLayout.visibility == View.GONE) {
                holder.dropdownLayout.visibility = View.VISIBLE
                holder.buttonPlus.setImageResource(R.drawable.minus)
            } else {
                holder.dropdownLayout.visibility = View.GONE
                holder.buttonPlus.setImageResource(R.drawable.add)
            }
        }
//        holder.buttonPlus.setOnClickListener {
//            if (holder.dropdownLayout.visibility == View.GONE) {
//                holder.dropdownLayout.visibility = View.VISIBLE
//                holder.buttonPlus.setImageResource(R.drawable.minus) // Đặt hình ảnh mới (ví dụ: dấu trừ)
//            } else {
//                holder.dropdownLayout.visibility = View.GONE
//                holder.buttonPlus.setImageResource(R.drawable.add) // Đặt hình ảnh mới (ví dụ: dấu cộng)
//            }
//        }

    }

    override fun getItemCount() = items.size
}