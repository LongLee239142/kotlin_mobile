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

class DropdownAdapter1(
    private val items: List<DataSource>,
    private val itemsDropdown: List<DataSourceDropdown1>,
    private val itemsDropdown1: List<DataSourceDropdown1_1>? = null
) : RecyclerView.Adapter<DropdownAdapter1.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val headerLayout: LinearLayout = itemView.findViewById(R.id.headerLayout1)
        val headerTitle: TextView = itemView.findViewById(R.id.headerTitle1)
        val textView: TextView = itemView.findViewById(R.id.textView1)
        val dropdownLayout: LinearLayout = itemView.findViewById(R.id.dropdownLayout1)
        val buttonPlus: ImageView = itemView.findViewById(R.id.imageView1)
        val recyclerViewDropdown: RecyclerView =
            itemView.findViewById(R.id.dropdown_menu_meal_full1)
        val recyclerViewDropdown1: RecyclerView =
            itemView.findViewById(R.id.dropdown_menu_meal_full1_1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_meal_collapsed1, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.headerTitle.text = item.tilteName
        holder.textView.text = item.note
        holder.recyclerViewDropdown.layoutManager =
            LinearLayoutManager(holder.dropdownLayout.context)
        holder.recyclerViewDropdown.adapter = DropdownMealFullAdapter1(itemsDropdown)
        holder.recyclerViewDropdown1.layoutManager =
            LinearLayoutManager(holder.dropdownLayout.context)
        holder.recyclerViewDropdown1.adapter =
            itemsDropdown1?.let { DropdownMealFullAdapter1_1(it) }

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