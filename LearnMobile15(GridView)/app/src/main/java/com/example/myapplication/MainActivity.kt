package com.example.myapplication

import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //khai báo list danh sách
        val list = mutableListOf<OutData>()
        list.add(OutData(R.drawable.movie1, "Movie 1"))
        list.add(OutData(R.drawable.movie2, "Movie 2"))
        list.add(OutData(R.drawable.movie3, "Movie 3"))
        list.add(OutData(R.drawable.movie4, "Movie 4"))
        list.add(OutData(R.drawable.movie5, "Movie 5"))
        list.add(OutData(R.drawable.movie6, "Movie 6"))
        list.add(OutData(R.drawable.movie7, "Movie 7"))
        list.add(OutData(R.drawable.movie5, "Movie 5"))
        list.add(OutData(R.drawable.movie6, "Movie 6"))
        list.add(OutData(R.drawable.movie7, "Movie 7"))
        val customGrid = CustomGirdView(this, list)
        binding.gvMovie.adapter = customGrid

        binding.gvMovie.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                Toast.makeText(
                    this,
                    "You have Chosen " + list[position].movieName,
                    Toast.LENGTH_SHORT
                ).show()
            }
    }
}