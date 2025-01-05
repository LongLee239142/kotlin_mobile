package com.example.myapplication

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var customAdapter: CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //khai bao danh sach item list
        var list = mutableListOf<OutData>()
        list.add(OutData(R.drawable.image1, "Chi Dau", " This is a description of Chi Dau"))
        list.add(OutData(R.drawable.image2, "Run Away", " This is a description of Run Away"))
        list.add(
            OutData(
                R.drawable.image3,
                "Quy Hoi Quan",
                " This is a description of Quy Hoi Quan"
            )
        )
        list.add(OutData(R.drawable.image4, "Lion King", " This is a description of Lion King"))
        list.add(OutData(R.drawable.image5, "Kính Vạn Hoa", " This is a description of Kính Vạn Hoa"))
        list.add(OutData(R.drawable.image6, "Sonic 3", " This is a description of Sonic 3"))
        list.add(OutData(R.drawable.image7, "Mưa trên cách bướm", " This is a description of Mưa trên cánh Bướm"))
        list.add(OutData(R.drawable.image4, "Lion King", " This is a description of Lion King"))
        list.add(OutData(R.drawable.image5, "Kính Vạn Hoa", " This is a description of Kính Vạn Hoa"))
        list.add(OutData(R.drawable.image6, "Sonic 3", " This is a description of Sonic 3"))
        list.add(OutData(R.drawable.image7, "Mưa trên cách bướm", " This is a description of Mưa trên cánh Bướm"))
        list.add(OutData(R.drawable.image4, "Lion King", " This is a description of Lion King"))
        list.add(OutData(R.drawable.image5, "Kính Vạn Hoa", " This is a description of Kính Vạn Hoa"))
        list.add(OutData(R.drawable.image6, "Sonic 3", " This is a description of Sonic 3"))
        list.add(OutData(R.drawable.image7, "Mưa trên cách bướm", " This is a description of Mưa trên cánh Bướm"))
        list.add(OutData(R.drawable.image4, "Lion King", " This is a description of Lion King"))
        list.add(OutData(R.drawable.image5, "Kính Vạn Hoa", " This is a description of Kính Vạn Hoa"))
        list.add(OutData(R.drawable.image6, "Sonic 3", " This is a description of Sonic 3"))
        list.add(OutData(R.drawable.image7, "Mưa trên cách bướm", " This is a description of Mưa trên cánh Bướm"))
        customAdapter = CustomAdapter(this,list)

        //khai báo 1 biến  link tới listMovie
        val listMovie = findViewById<ListView>(R.id.listMovie)
        listMovie.adapter = customAdapter

        // listview item click listener
        listMovie.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "You have to choose " + list[position].title, Toast.LENGTH_SHORT).show()
        }
    }
}