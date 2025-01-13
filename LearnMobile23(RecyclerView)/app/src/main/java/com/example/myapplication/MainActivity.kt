package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Gắn binding với layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handler()
    }

    private fun handler() {
        val list = mutableListOf<Int>()
        list.add(R.drawable.image1)
        list.add(R.drawable.image3)
        list.add(R.drawable.image1)
        list.add(R.drawable.image4)
        list.add(R.drawable.image3)
        list.add(R.drawable.image1)
        list.add(R.drawable.image5)
        list.add(R.drawable.image6)
        list.add(R.drawable.image4)
        list.add(R.drawable.image5)
        list.add(R.drawable.image3)
        list.add(R.drawable.image6)
        list.add(R.drawable.image4)
        list.add(R.drawable.image6)

        val itemAdapter = RvAdapter(list, object : RvInterface {
            override fun OnClickItem(pos: Int) {
                Toast.makeText(
                    this@MainActivity,
                    "You have been Click on ${list[pos]}",
                    Toast.LENGTH_SHORT
                ).show()
            }

        })
        binding.RvView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.RvView.adapter = itemAdapter
    }

}