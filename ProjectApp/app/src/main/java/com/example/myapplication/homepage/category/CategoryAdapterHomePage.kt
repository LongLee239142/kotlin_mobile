package com.example.myapplication.homepage.category

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.allCatergories.Category

class CategoryAdapterHomePage(private val categories: List<Category>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // Xác định viewType
    private val VIEW_TYPE_CATEGORY = 0
    private val VIEW_TYPE_EXTRA = 1

    // ViewHolder cho mục thông thường
    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imageItem)
        val text: TextView = itemView.findViewById(R.id.name_item)
        val label: TextView = itemView.findViewById(R.id.labelNew)
    }

    // ViewHolder cho mục đặc biệt
    inner class ExtraViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageItem: ImageView = itemView.findViewById(R.id.imageItem)
        val nameItem: TextView = itemView.findViewById(R.id.name_item)
    }

    override fun getItemViewType(position: Int): Int {
        // Nếu là mục cuối cùng (view bổ sung)
        if (categories.size <= 5)
            return if (position == categories.size) VIEW_TYPE_EXTRA else VIEW_TYPE_CATEGORY
        else return if (position == 5) VIEW_TYPE_EXTRA else VIEW_TYPE_CATEGORY
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_CATEGORY) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_item2, parent, false)
            CategoryViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_seeall, parent, false)
            ExtraViewHolder(view)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CategoryViewHolder) {
            val category = categories[position]
            holder.image.setImageResource(category.imageRes)
            holder.text.text = category.name
            if (category.label == null) {
                holder.label.visibility = View.GONE
            } else {
                when (category.label) {
                    "NEW" -> {
                        holder.label.setBackgroundResource(R.drawable.label_background)
                        holder.label.text = "NEW"
                    }

                    "FAVS" -> {
                        holder.label.setBackgroundResource(R.drawable.label_background2)
                        holder.label.text = "FAVS"
                    }
                }
            }
        }
//        else if (holder is ExtraViewHolder) {
//            // Thiết lập nội dung cho View bổ sung
//            holder.imageItem.setImageResource(R.drawable.arrow_right)
//            holder.nameItem.text = "See all"
//
//            // Xử lý sự kiện onclick
//            holder.itemView.setOnClickListener {
//                Toast.makeText(holder.itemView.context, "See all clicked", Toast.LENGTH_SHORT).show()
//
//                // Đổi hình ảnh và màu chữ khi click
//                holder.imageItem.setImageResource(R.drawable.arrow_right_blue)
//                holder.nameItem.setTextColor(Color.parseColor("#45B8E9"))
//            }
//        }
        else if (holder is ExtraViewHolder) {
            holder.imageItem.setImageResource(R.drawable.arrow_right) // Ảnh mặc định
            holder.nameItem.text = "See all" // Văn bản mặc định

            var isClicked = false // Biến trạng thái click

            // Xử lý sự kiện onClick
            holder.itemView.setOnClickListener {
                isClicked = !isClicked // Đảo trạng thái

                if (isClicked) {
                    // Trạng thái khi click
                    holder.imageItem.setImageResource(R.drawable.arrow_right_blue)
                    holder.nameItem.setTextColor(Color.parseColor("#45B8E9"))
                } else {
                    // Trạng thái mặc định
                    holder.imageItem.setImageResource(R.drawable.arrow_right)
                    holder.nameItem.setTextColor(Color.BLACK)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        // Tăng số lượng mục để thêm View bổ sung
        return if (categories.size > 5) 6 else categories.size + 1
    }
}
