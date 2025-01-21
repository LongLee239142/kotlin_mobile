package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.catergorypage.CustomListItem1
import com.example.myapplication.catergorypage.CustomListItem2
import com.example.myapplication.catergorypage.OutData1
import com.example.myapplication.catergorypage.OutData2
import com.example.myapplication.databinding.ActivityCatergoryPageBinding

class CategoryPage : AppCompatActivity() {
    private lateinit var binding: ActivityCatergoryPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_catergory_page)
        binding = ActivityCatergoryPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list = mutableListOf<OutData1>()
        list.add(OutData1(R.drawable.rame, "BBQ Chicken Burger", "KFC"))
        list.add(OutData1(R.drawable.rame, "BBQ Chicken Burger", "KFC"))
        val customList = CustomListItem1(this, list)
        val list_1 = mutableListOf<OutData2>()
        list_1.add(OutData2("McDonald’s", "18915 Queens Road, Brampton, ON"))
        list_1.add(OutData2("McDonald’s", "18915 Queens Road, Brampton, ON"))
        list_1.add(OutData2("McDonald’s", "18915 Queens Road, Brampton, ON"))
        val customList1 = CustomListItem2(this, list_1)
        binding.listItem1.adapter = customList
        binding.listItem2.adapter = customList1
        binding.backButton.setOnClickListener{
            Toast.makeText(applicationContext,"You have click on Back",Toast.LENGTH_SHORT).show()
        }
    }
}