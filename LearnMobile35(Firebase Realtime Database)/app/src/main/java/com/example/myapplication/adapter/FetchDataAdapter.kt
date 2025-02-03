package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.EmployeeModel

class FetchDataAdapter(
    val listData: ArrayList<EmployeeModel>
) : RecyclerView.Adapter<FetchDataAdapter.ViewHolder>() {
//code adapter lắng nghe sự kiện
    private lateinit var mListener: onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(clickListener: onItemClickListener){
        mListener = clickListener
    }

    inner class ViewHolder(itemView: View,clickListener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val tileName: TextView = itemView.findViewById(R.id.list_data)
        init {
            itemView.setOnClickListener {
                clickListener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_data, parent, false)
        return ViewHolder(view, mListener )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listData[position]
        holder.tileName.text = item.empName
    }

    override fun getItemCount() = listData.size

}