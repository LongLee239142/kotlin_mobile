package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomCatergories(val activity: Activity, val list: List<OutData2>) :
ArrayAdapter<OutData2>(activity, R.layout.layout_item2) {
    override fun getCount(): Int {
        return list.size
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val contexs = activity.layoutInflater
        val rowView = contexs.inflate(R.layout.layout_item2, parent, false) // dòng lệnh này giúp chuyển layout Xml thành view
        val images = rowView.findViewById<ImageView>(R.id.imageItem)
        val txtName = rowView.findViewById<TextView>(R.id.name_item)
        images.setImageResource(list[position].imageItem)
        txtName.text = list[position].ItemName
        return rowView
    }
}