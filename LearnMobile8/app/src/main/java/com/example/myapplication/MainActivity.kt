package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
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
        binding.radImage1.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                binding.imageView.setImageResource(R.drawable.longle)
            }
        }
        binding.radImage2.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                binding.imageView.setImageResource(R.drawable.longlee)
            }
        }
        binding.btnExit.setOnClickListener{
            Toast.makeText(this, "You have exited", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}