package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
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
        val list = resources.getStringArray(R.array.Province)

        val adt = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        binding.autoCompleteProvince.setAdapter(adt)

        // Gợi ý với 0 char nhập vào
        binding.autoCompleteProvince.setOnFocusChangeListener(View.OnFocusChangeListener { v, hasFocus ->
            if (hasFocus)
                binding.autoCompleteProvince.showDropDown()
        })

        // Kiểm tra xem item nào được chọn
        binding.autoCompleteProvince.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(
                this,
                "Click item " + binding.autoCompleteProvince.text.toString(),
                Toast.LENGTH_SHORT
            ).show()
        })
    }
}