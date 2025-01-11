package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.LayoutItemBinding

class RvAdapterhight(var ds: List<OutData>, val onMoiveClick:RvInterface) : RecyclerView.Adapter<RvAdapterhight.PhimViewHolder>() {

    inner class PhimViewHolder(val binding: LayoutItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhimViewHolder {
        // Sử dụng LayoutItemBinding.inflate để khởi tạo ViewBinding
        val binding = LayoutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhimViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhimViewHolder, position: Int) {
        // Truy cập ViewBinding thông qua holder
        holder.binding.apply {
            imgMovie.setImageResource(ds[position].images)
            txtMovie.text = ds[position].nameMovie
            txtDescription.text = ds[position].description
            //Lắng nghe item Click chọn
            holder.itemView.setOnClickListener {
                onMoiveClick.OnClickMovie(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return ds.size
    }
}
