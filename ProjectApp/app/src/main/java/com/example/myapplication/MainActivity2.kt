package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMain2Binding
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val list = mutableListOf<OutData2>()
        list.add(OutData2(R.drawable.image_7,"Item 1"))
        list.add(OutData2(R.drawable.image_8,"Item 3"))
        list.add(OutData2(R.drawable.image_10,"Item 4"))
        list.add(OutData2(R.drawable.image_11,"Item 5"))
        list.add(OutData2(R.drawable.image_12,"Item 6"))
        val customGrid = CustomCatergories(this, list)
        binding.categories.adapter = customGrid
    }
}