package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list: MutableList<String> = mutableListOf("09123123123", "09123445655")
    private lateinit var phoneNumberHandler: PhoneNumberHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Khởi tạo view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Khởi tạo lớp xử lý logic
        phoneNumberHandler = PhoneNumberHandler(this, binding, list)
        
        // Cấu hình giao diện và xử lý sự kiện
        phoneNumberHandler.setupUI()
        phoneNumberHandler.handleEvents()
    }
}
