package com.example.myapplication

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //khởi tạo viewbinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addEvent()
    }

    private fun addEvent() {
        handlerEvent()
    }

    private fun handlerEvent() {
        displayCountries()
        changeColorList()
    }

    private fun changeColorList() {
        val blue = Color.parseColor("#99FFFF")
        binding.listCountries.setBackgroundColor(blue)
    }

    private fun displayCountries() {
        // khai bao su dung resources de lay thong tin tu strings.xml
        var arrCountries = resources.getStringArray(R.array.arrCountries)
        //gan nguon cho adapter de hien thi len man hinh
        binding.listCountries.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, arrCountries
        )
        binding.listCountries.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(
                this, "You choose " + arrCountries[position], Toast.LENGTH_SHORT
            ).show()
        }
    }
}