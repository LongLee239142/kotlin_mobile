package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.mealcollapsed.DataSource
import com.example.myapplication.mealcollapsed.DropdownAdapter
import com.example.myapplication.mealcollapsed.DropdownAdapter1
import com.example.myapplication.mealcollapsed.DropdownAdapter2

class MealCollapsed : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_meal_collapsed)
        val items = mutableListOf<DataSource>()
        items.add(DataSource("Side Item","REQUIRED"))
        val items1 = mutableListOf<DataSource>()
        items1.add(DataSource("Drinks","REQUIRED"))

        val items2 = mutableListOf<DataSource>()
        items2.add(DataSource("Edit Cheeseburger"))

        // Thiết lập RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = DropdownAdapter(items)
        val recyclerView1: RecyclerView = findViewById(R.id.recyclerView1)
        recyclerView1.layoutManager = LinearLayoutManager(this)
        recyclerView1.adapter = DropdownAdapter1(items1)
        val recyclerView2: RecyclerView = findViewById(R.id.recyclerView2)
        recyclerView2.layoutManager = LinearLayoutManager(this)
        recyclerView2.adapter = DropdownAdapter2(items2)
    }
}