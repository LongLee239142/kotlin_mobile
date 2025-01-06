package com.example.myapplication

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomSpiner(val activity: Activity, val list: List<OutData>) :
    ArrayAdapter<OutData>(activity, R.layout.list_food) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // position: Int vị trí của item trong
        // convertView: View ? chế độ xem từng mục trong
        // parent: ViewGroup cha đang chứa spinner
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)

    }
// xu ly view
    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {
        val contexs = activity.layoutInflater
        //layoutInflater giúp chuyển đổi 1 layout xml thành view trong
        val rowView = contexs.inflate(R.layout.list_food, parent, false) // dòng lệnh này giúp chuyển layout Xml thành view
        val images = rowView.findViewById<ImageView>(R.id.imageView)
        val txtFood = rowView.findViewById<TextView>(R.id.txtFoodName)
        images.setImageResource(list[position].image)
        txtFood.text = list[position].description
        return rowView
    }

}