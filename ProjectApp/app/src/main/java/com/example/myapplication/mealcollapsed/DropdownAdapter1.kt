package com.example.myapplication.mealcollapsed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class DropdownAdapter1(private val items: List<DataSource>) :
    RecyclerView.Adapter<DropdownAdapter1.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val headerLayout: LinearLayout = itemView.findViewById(R.id.headerLayout1)
        val headerTitle: TextView = itemView.findViewById(R.id.headerTitle1)
        val textView: TextView = itemView.findViewById(R.id.textView1)
        val dropdownLayout: LinearLayout = itemView.findViewById(R.id.dropdownLayout1)
        val buttonPlus: ImageView = itemView.findViewById(R.id.imageView1)
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