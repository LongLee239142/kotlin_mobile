package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMain2Binding
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        //Lấy dữ liệu từ intent main
        val i = intent
//        val getString = i.getStringExtra("bienString")
//        val getDouble = i.getDoubleExtra("bienDouble",0.0)
//        val getBoolean = i.getBooleanExtra("bienBoolean",false)

        // lấy bundle ra khỏi intent
        val bundle = i.extras
        if (bundle != null) {
            val getString = bundle.getString("bienString")
            val getDouble = bundle.getDouble("bienDouble", 0.0)
            val getBoolean = bundle.getBoolean("bienBoolean", false)
            binding.edtGetData.setText("$getString \n $getBoolean \n $getDouble")
        }

        // gọi màn hình 2 từ màn hình main
        binding.btnGo1.setOnClickListener {
            val intent1 = Intent(this, MainActivity::class.java)
            startActivity(intent1)
        }
    }
}