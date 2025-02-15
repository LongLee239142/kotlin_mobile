package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

@Suppress("UNREACHABLE_CODE")
class CustomGirdView(val activity: Activity, val list: List<OutData>) :
    ArrayAdapter<OutData>(activity, R.layout.layout_item) {
    override fun getCount(): Int {
        return list.size
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val contexs = activity.layoutInflater
        val rowView = contexs.inflate(R.layout.layout_item, parent, false) // dòng lệnh này giúp chuyển layout Xml thành view
        val images = rowView.findViewById<ImageView>(R.id.imageMovie)
        val txtName = rowView.findViewById<TextView>(R.id.txtNameMovie)
        images.setImageResource(list[position].images)
         txtName.text = list[position].movieName
        return rowView
    }
}