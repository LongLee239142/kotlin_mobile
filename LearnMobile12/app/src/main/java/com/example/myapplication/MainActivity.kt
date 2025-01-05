package com.example.myapplication

import android.annotation.SuppressLint
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
        //khởi tạo viewbinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpSpinnerBase()
    }

    private fun setUpSpinnerBase() {
//        val list = resources.getStringArray(R.array.language)
        val list = mutableListOf<String>()
        list.add("VietNam")
        list.add("Tay Ban Nha")
        list.add("Bo Dao Nha")
        list.add("Ha Lan")
        //khai báo bộ điều hướng
        val adt =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, list)// cách hiển thị 1 dòng
        binding.spLanguage.adapter = adt
        //onItemSelectedListener
        binding.spLanguage.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@MainActivity,"You have chosen " + list[position],Toast.LENGTH_SHORT ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }


}