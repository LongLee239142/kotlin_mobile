package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityMealCollapsedBinding
import com.example.myapplication.mealcollapsed.dataoutsource.DataSource
import com.example.myapplication.mealcollapsed.dropdownadapter.DropdownAdapter
import com.example.myapplication.mealcollapsed.dropdownadapter.DropdownAdapter1
import com.example.myapplication.mealcollapsed.dropdownadapter.DropdownAdapter2
import com.example.myapplication.mealcollapsed.dropdownadapter.dropdownmealfull.DataSourceDropdown
import com.example.myapplication.mealcollapsed.dropdownadapter.dropdownmealfull1.DataSourceDropdown1
import com.example.myapplication.mealcollapsed.dropdownadapter.dropdownmealfull1.DataSourceDropdown1_1

class MealCollapsed : AppCompatActivity() {
    private lateinit var binding: ActivityMealCollapsedBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_meal_collapsed)
        binding = ActivityMealCollapsedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backButton.setOnClickListener {
            Toast.makeText(this,"You want to come back",Toast.LENGTH_SHORT).show()
        }
        val items = mutableListOf<DataSource>()
        items.add(DataSource("Side Item", "REQUIRED"))
        val itemsDropdown =
            mutableListOf<DataSourceDropdown>()
        itemsDropdown.add(
            DataSourceDropdown(
                R.drawable.large_fries,
                "Large Fries",
            )
        )
        itemsDropdown.add(
            DataSourceDropdown(
                R.drawable.large_fries,
                "Large Fries",
                "3.2$"
            )
        )
        val itemsDropdown1 =
            mutableListOf<DataSourceDropdown1>()
        itemsDropdown1.add(DataSourceDropdown1("Soft Drinks"))
        itemsDropdown1.add(DataSourceDropdown1("Juices"))
        val itemsDropdown1_1 =
            mutableListOf<DataSourceDropdown1_1>()
        itemsDropdown1_1.add(DataSourceDropdown1_1(R.drawable.strbr,"Fruit Punch Juice"))

        val items1 = mutableListOf<DataSource>()
        items1.add(DataSource("Drinks", "REQUIRED"))

        val items2 = mutableListOf<DataSource>()
        items2.add(DataSource("Edit Cheeseburger"))

        // Thiết lập RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = DropdownAdapter(items,itemsDropdown)
        val recyclerView1: RecyclerView = findViewById(R.id.recyclerView1)
        recyclerView1.layoutManager = LinearLayoutManager(this)
        recyclerView1.adapter = DropdownAdapter1(items1,itemsDropdown1,itemsDropdown1_1)
        val recyclerView2: RecyclerView = findViewById(R.id.recyclerView2)
        recyclerView2.layoutManager = LinearLayoutManager(this)
        recyclerView2.adapter = DropdownAdapter2(items2)

    }
}