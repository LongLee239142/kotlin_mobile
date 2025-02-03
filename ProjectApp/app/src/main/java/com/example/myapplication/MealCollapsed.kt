package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMealCollapsedBinding
import com.example.myapplication.mealcollapsed.dataoutsource.DataSource
import com.example.myapplication.mealcollapsed.dropdownadapter.DropdownAdapter
import com.example.myapplication.mealcollapsed.dropdownadapter.DropdownAdapter1
import com.example.myapplication.mealcollapsed.dropdownadapter.DropdownAdapter2
import com.example.myapplication.mealcollapsed.dropdownadapter.dropdownmealfull.DataSourceDropdown
import com.example.myapplication.mealcollapsed.dropdownadapter.dropdownmealfull1.DataSourceDropdown1
import com.example.myapplication.mealcollapsed.dropdownadapter.dropdownmealfull1.DataSourceDropdown1_1
import com.example.myapplication.mealcollapsed.dropdownadapter.dropdownmealfull2.DataSourceDropdown2
import com.example.myapplication.mealcollapsed.dropdownadapter.dropdownmealfull2.DataSourceDropdown2_1
import com.example.myapplication.mealcollapsed.dropdownadapter.dropdownmealfull2.DataSourceDropdown2_2

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

        //Items to dropdown and in dropdown
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

        //item to dropdown1 and in dropdown1
        val items1 = mutableListOf<DataSource>()
        items1.add(DataSource("Drinks", "REQUIRED"))
        val itemsDropdown1 =
            mutableListOf<DataSourceDropdown1>()
        itemsDropdown1.add(DataSourceDropdown1("Soft Drinks"))
        itemsDropdown1.add(DataSourceDropdown1("Juices"))
        val itemsDropdown1_1 =
            mutableListOf<DataSourceDropdown1_1>()
        itemsDropdown1_1.add(DataSourceDropdown1_1(R.drawable.strbr,"Fruit Punch Juice"))



        //item to dropdown2 and in dropdown2
        val items2 = mutableListOf<DataSource>()
        items2.add(DataSource("Edit Cheeseburger"))
        val itemsDropdown2 =
            mutableListOf<DataSourceDropdown2>()
        itemsDropdown2.add(DataSourceDropdown2(R.drawable.strbr,"Fruit Punch Juice"))

        val itemsDropdown2_1 =
            mutableListOf<DataSourceDropdown2_1>()
        itemsDropdown2_1.add(DataSourceDropdown2_1(R.drawable.strbr,"Fruit Punch Juice","1"))
        itemsDropdown2_1.add(DataSourceDropdown2_1(R.drawable.strbr,"Fruit Punch Juice","3"))
        itemsDropdown2_1.add(DataSourceDropdown2_1(R.drawable.strbr,"Fruit Punch Juice","2"))
        itemsDropdown2_1.add(DataSourceDropdown2_1(R.drawable.strbr,"Fruit Punch Juice","1"))

        val itemsDropdown2_2 =
            mutableListOf<DataSourceDropdown2_2>()
        itemsDropdown2_2.add(DataSourceDropdown2_2(R.drawable.strbr,"Fruit Punch Juice"))
        itemsDropdown2_2.add(DataSourceDropdown2_2(R.drawable.strbr,"Fruit Punch Juice"))


        // Thiết lập RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = DropdownAdapter(items,itemsDropdown)
        val recyclerView1: RecyclerView = findViewById(R.id.recyclerView1)
        recyclerView1.layoutManager = LinearLayoutManager(this)
        recyclerView1.adapter = DropdownAdapter1(items1,itemsDropdown1,itemsDropdown1_1)
        val recyclerView2: RecyclerView = findViewById(R.id.recyclerView2)
        recyclerView2.layoutManager = LinearLayoutManager(this)
        recyclerView2.adapter = DropdownAdapter2(items2,itemsDropdown2,itemsDropdown2_1,itemsDropdown2_2)

    }
}