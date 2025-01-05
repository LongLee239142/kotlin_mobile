package com.example.myapplication

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(val activity: MainActivity,val list: List<OutData>):ArrayAdapter<OutData>(activity,R.layout.list_items) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val contexs = activity.layoutInflater // layoutInflater la 1 component giup chuyen file xml -> view trong android
        val rowView = contexs.inflate(R.layout.list_items,parent,false)
        val image = rowView.findViewById<ImageView>(R.id.images)
        val title = rowView.findViewById<TextView>(R.id.title)
        val desc = rowView.findViewById<TextView>(R.id.description)
        title.text = list[position].title
        desc.text = list[position].description
        image.setImageResource(list[position].image)
        return rowView
    }
}