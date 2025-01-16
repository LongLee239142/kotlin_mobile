package com.example.myapplication.catergorypage

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R

class CustomListItem2(val activity: Activity, val list: List<OutData2>) :
    ArrayAdapter<OutData2>(activity, R.layout.layout_item_category_page2) {
    override fun getCount(): Int {
        return list.size
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val contexs = activity.layoutInflater
        val rowView = contexs.inflate(R.layout.layout_item_category_page2, parent, false) // dòng lệnh này giúp chuyển layout Xml thành view
        val txtName = rowView.findViewById<TextView>(R.id.title)
        val des = rowView.findViewById<TextView>(R.id.description)
        des.text = list[position].description
        txtName.text = list[position].itemName
        return rowView
    }
}