package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.allCatergories.Category
import com.example.myapplication.allCatergories.CategoryAdapter


class AllCategory : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val recyclerView1: RecyclerView = findViewById(R.id.recycler_view2)

        // Dữ liệu mẫu
        val categories = listOf(
            Category("Burgers", R.drawable.ic_burgers,"NEW"),
            Category("Burgers", R.drawable.ic_burgers,"NEW"),
            Category("Burgers", R.drawable.ic_burgers,"NEW"),
            Category("Burgers", R.drawable.ic_burgers,"NEW"),
            Category("Burgers", R.drawable.ic_burgers,"NEW"),
            Category("Burgers", R.drawable.ic_burgers,"NEW"),
            Category("Grocery", R.drawable.image_8),
            Category("Salads", R.drawable.image_10),
            Category("Pizza", R.drawable.ic_burgers),
            Category("Chicken", R.drawable.ic_burgers),
            Category("Salads", R.drawable.image_10,"FAVS"),
            Category("Grocery", R.drawable.image_8),
            Category("Chicken", R.drawable.ic_burgers),
            Category("Salads", R.drawable.image_10,"FAVS"),
            Category("Grocery", R.drawable.image_8),
            Category("Chicken", R.drawable.image_10,"FAVS"),
            Category("Chinese", R.drawable.ic_burgers)
        )
        // Hàm giúp tái sử dụng logic tạo RecyclerView
        fun setupRecyclerView(recyclerView: RecyclerView, items: List<Category>, spanCount: Int) {
            val adapter = CategoryAdapter(items)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = GridLayoutManager(this, spanCount)
        }

        val num: Int = categories.size % 3

        when (num) {
            1 -> {
                val firstNMinusOneItems = categories.take(categories.size - 1)
                val lastItem = categories.takeLast(1)

                setupRecyclerView(recyclerView, firstNMinusOneItems, 3)
                setupRecyclerView(recyclerView1, lastItem, 1)
            }

            2 -> {
                val firstNMinusOneItems = categories.take(categories.size - 2)
                val lastItems = categories.takeLast(2)

                setupRecyclerView(recyclerView, firstNMinusOneItems, 3)
                setupRecyclerView(recyclerView1, lastItems, 2)
            }

            0 -> {
                setupRecyclerView(recyclerView, categories, 3)
            }
        }


    }
}