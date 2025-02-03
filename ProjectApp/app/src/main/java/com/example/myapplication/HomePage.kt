package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.myapplication.allCatergories.Category
import com.example.myapplication.homepage.category.CategoryAdapterHomePage
import com.example.myapplication.homepage.newtrending.DataNewTrending
import com.example.myapplication.homepage.newtrending.DataNewTrendingAdapter
import com.example.myapplication.homepage.offernear.DataNearOffer
import com.example.myapplication.homepage.offernear.DataNearOfferAdapter

class HomePage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewMain)
        val recyclerView1: RecyclerView = findViewById(R.id.recyclerViewNearOffer)
        val recyclerView2: RecyclerView = findViewById(R.id.recyclerNewTrending)

        // Dữ liệu mẫu categories
        val categories = listOf(
            Category("Burgers", R.drawable.ic_burgers),
            Category("Burgers", R.drawable.ic_burgers),
            Category("Burgers", R.drawable.ic_burgers),
            Category("Burgers", R.drawable.ic_burgers),
            Category("Chinese", R.drawable.ic_burgers)
        )
        val adapter = CategoryAdapterHomePage(categories)
        recyclerView.layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
        recyclerView.adapter = adapter


        //Dữ liệu mẫu DataNearOffer
        val nearOffer = listOf(
            DataNearOffer(R.drawable.cakecover),
            DataNearOffer(R.drawable.cakecover),
            DataNearOffer(R.drawable.cakecover)
        )
        val adapter1 = DataNearOfferAdapter(nearOffer)
        recyclerView1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView1.adapter = adapter1



        //Dữ liệu mẫu DataNewtrending
        val newTrending = listOf(
            DataNewTrending(R.drawable.covernewtrending,R.drawable.kfc,"Harvey’s","2.1 mi"),
            DataNewTrending(R.drawable.covernewtrending,R.drawable.kfc,"Harvey’s","2.1 mi"),
            DataNewTrending(R.drawable.covernewtrending,R.drawable.kfc,"Harvey’s","2.1 mi")
        )
        val adapter2 = DataNewTrendingAdapter(newTrending)
        recyclerView2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView2.adapter = adapter2


    }
}