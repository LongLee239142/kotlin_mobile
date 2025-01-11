package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
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
        // Gắn binding với layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // gọi màn hình 2 từ màn hình main
        binding.btnGo.setOnClickListener {
            val intent1 = Intent(this,MainActivity2::class.java)
            // truyền dữ liệu trực tiếp bằng
//            intent1.putExtra("bienString","Welcome to LongLee")
//            intent1.putExtra("bienDouble",79.79)
//            intent1.putExtra(ç
            //Truyền dữ liệu bằng bằng bundel
            //1. nạp dữ liệu
            val bundle = Bundle()
            bundle.putString("bienString","Welcome to LongLee")
            bundle.putDouble("bienDouble",39.79)
            bundle.putBoolean("bienBoolean",true)

            // đặt bundle vào trong intent
            intent1.putExtras(bundle)



            startActivity(intent1)
        }

        binding.btnGo1.setOnClickListener{
            val intent2 = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.facebook.com/long.ld911/?locale=vi_VN"))
            startActivity(intent2)
        }
    }
}