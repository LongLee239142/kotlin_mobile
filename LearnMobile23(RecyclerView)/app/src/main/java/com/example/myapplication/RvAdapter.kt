package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.LayoutItemBinding

class RvAdapter(private val ds: List<Int>,val onClickItem:RvInterface) : RecyclerView.Adapter<RvAdapter.itemViewHolder>() {
    class itemViewHolder(val binding: LayoutItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val binding = LayoutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return itemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        holder.binding.apply {
            imageView2.setImageResource(ds[position])
            holder.itemView.setOnClickListener {
                onClickItem.OnClickItem(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return ds.size
    }
}