package com.example.myapplication.mealcollapsed.dropdownadapter.dropdownmealfull

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R


class DropdownMealFullAdapter(private val items: List<DataSourceDropdown>) :
    RecyclerView.Adapter<DropdownMealFullAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageProduct: ImageView = itemView.findViewById(R.id.imageProduct)
        val textView: TextView = itemView.findViewById(R.id.titleProduct)
        val priceProduc: TextView = itemView.findViewById(R.id.priceProduct)
        val radioButton: RadioButton = itemView.findViewById(R.id.radioButton)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dropdow_meal_full, parent, false)
        return ViewHolder(view)
    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = items[position]

        // Thiết lập hình ảnh sản phẩm
        holder.imageProduct.setImageResource(item.imageProduct)

        // Thiết lập tên sản phẩm
        holder.textView.text = item.tilteName

        // Kiểm tra giá trị `price` trước khi thiết lập
        if (item.price.isNullOrEmpty()) {
            holder.priceProduc.visibility = View.GONE // Ẩn TextView nếu giá trị null hoặc rỗng
        } else {
            holder.priceProduc.visibility = View.VISIBLE // Hiển thị nếu có giá trị
            holder.priceProduc.text = item.price
        }

        // Thiết lập trạng thái ban đầu cho RadioButton
        holder.radioButton.setOnCheckedChangeListener(null) // Ngắt kết nối listener để tránh vòng lặp
        holder.radioButton.isChecked = item.isCheckedState

        // Đặt màu sắc cho RadioButton dựa trên trạng thái
        holder.radioButton.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(
                holder.radioButton.context,
                if (item.isCheckedState) R.color.pink else R.color.gray
            )
        )

        // Lắng nghe sự kiện khi người dùng nhấn vào RadioButton
        holder.radioButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Đảm bảo chỉ có một RadioButton được chọn
                val previousSelectedIndex = items.indexOfFirst { it.isCheckedState }
                if (previousSelectedIndex != -1 && previousSelectedIndex != position) {
                    items[previousSelectedIndex].isCheckedState =
                        false // Bỏ chọn RadioButton trước đó
                    notifyItemChanged(previousSelectedIndex) // Cập nhật lại view của RadioButton trước đó
                }
                item.isCheckedState = true // Đánh dấu RadioButton hiện tại
                notifyItemChanged(position) // Cập nhật lại view của RadioButton hiện tại
            }
        }
    }


    override fun getItemCount() = items.size
}