package com.example.myapplication.catergorypage

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R

class CustomListItem1(val activity: Activity, val list: List<OutData1>) :
    ArrayAdapter<OutData1>(activity, R.layout.layout_item_category_page1) {
    override fun getCount(): Int {
        return list.size
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val contexs = activity.layoutInflater
        val rowView = contexs.inflate(R.layout.layout_item_category_page1, parent, false) // dòng lệnh này giúp chuyển layout Xml thành view
        val images = rowView.findViewById<ImageView>(R.id.images)
        val imageButton = rowView.findViewById<ImageButton>(R.id.imageButton3)
        val txtName = rowView.findViewById<TextView>(R.id.title)
        val des = rowView.findViewById<TextView>(R.id.description)
        images.setImageResource(list[position].imageItem)
        des.text = list[position].description
        txtName.text = list[position].itemName
        imageButton.setOnClickListener {
            Toast.makeText(activity, "You have click on button Forward", Toast.LENGTH_SHORT).show()
        }
        return rowView
    }
}