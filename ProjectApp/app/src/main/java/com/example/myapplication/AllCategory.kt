package com.example.myapplication

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.allCatergories.Category
import com.example.myapplication.allCatergories.CategoryAdapter
import com.example.myapplication.databinding.ActivityMain2Binding


class AllCategory : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Khởi tạo ViewBinding
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Dữ liệu mẫu
        val categories = listOf(
            Category("Burgers", R.drawable.ic_burgers, "NEW"),
            Category("Burgers", R.drawable.ic_burgers),
            Category("Burgers", R.drawable.ic_burgers, "NEW"),
            Category("Burgers", R.drawable.ic_burgers),
            Category("Burgers", R.drawable.ic_burgers, "NEW"),
            Category("Burgers", R.drawable.ic_burgers, "FAVS"),
            Category("Grocery", R.drawable.image_8),
            Category("Salads", R.drawable.image_10),
            Category("Salads", R.drawable.image_10),
            Category("Salads", R.drawable.image_10),
            Category("Salads", R.drawable.image_10),
            Category("Pizza", R.drawable.ic_burgers),
            Category("Chicken", R.drawable.image_10, "FAVS"),
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

                setupRecyclerView(binding.recyclerView, firstNMinusOneItems, 3)
                setupRecyclerView(binding.recyclerView2, lastItem, 1)
            }

            2 -> {
                val firstNMinusOneItems = categories.take(categories.size - 2)
                val lastItems = categories.takeLast(2)

                setupRecyclerView(binding.recyclerView, firstNMinusOneItems, 3)
                setupRecyclerView(binding.recyclerView2, lastItems, 2)
            }

            0 -> {
                setupRecyclerView(binding.recyclerView, categories, 3)
            }
        }

        // Xử lý nút "Back"
        binding.backButton.setOnClickListener {
            val intent1 = Intent(this, HomePage::class.java)
            startActivity(intent1)
        }
    }
}
