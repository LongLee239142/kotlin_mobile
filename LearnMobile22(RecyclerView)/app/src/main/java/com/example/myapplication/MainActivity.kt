package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
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
        // tạo ds
        val list = mutableListOf<OutData>()
        list.add(OutData(R.drawable.movie1, "Movie 1", "this is movie 1"))
        list.add(OutData(R.drawable.movie2, "Movie 2", "this is movie 2"))
        list.add(OutData(R.drawable.movie3, "Movie 3", "this is movie 3"))
        list.add(OutData(R.drawable.movie1, "Movie 1", "this is movie 1"))
        list.add(OutData(R.drawable.movie2, "Movie 2", "this is movie 2"))
        list.add(OutData(R.drawable.movie3, "Movie 3", "this is movie 3"))
        list.add(OutData(R.drawable.movie1, "Movie 1", "this is movie 1"))
        list.add(OutData(R.drawable.movie2, "Movie 2", "this is movie 2"))
        list.add(OutData(R.drawable.movie3, "Movie 3", "this is movie 3"))
        val adapter = RvAdapterhight(list, object : RvInterface {
            override fun OnClickMovie(pos: Int) {
                Toast.makeText(
                    this@MainActivity,
                    "You have been Click on ${list[pos].nameMovie}",
                    Toast.LENGTH_SHORT
                ).show()
            }

        })
        binding.rvDemo.adapter = adapter
        binding.rvDemo.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL,
            false
        )
    }
}

