package com.example.myapplication

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

class CustomAdapter(val activity: MainActivity, val list: List<OutData>) :
    ArrayAdapter<OutData>(activity, R.layout.list_item) {
    override fun getCount(): Int {
        return list.size // vẽ lên view hết all row of list
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
         val contex = activity.layoutInflater //
        return super.getView(position, convertView, parent)
    }
}