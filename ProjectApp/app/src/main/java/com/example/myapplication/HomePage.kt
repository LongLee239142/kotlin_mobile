package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.myapplication.allCatergories.Category
import com.example.myapplication.homepage.category.CategoryAdapterHomePage

class HomePage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewMain)

        // Dữ liệu mẫu
        val categories = listOf(
            Category("Burgers", R.drawable.ic_burgers),
            Category("Burgers", R.drawable.ic_burgers),
            Category("Burgers", R.drawable.ic_burgers),
            Category("Burgers", R.drawable.ic_burgers),
            Category("Burgers", R.drawable.ic_burgers),
            Category("Burgers", R.drawable.ic_burgers),
            Category("Burgers", R.drawable.ic_burgers),
            Category("Burgers", R.drawable.ic_burgers),
            Category("Chinese", R.drawable.ic_burgers)
        )

        val adapter = CategoryAdapterHomePage(categories)
        recyclerView.layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
        recyclerView.adapter = adapter


    }
}