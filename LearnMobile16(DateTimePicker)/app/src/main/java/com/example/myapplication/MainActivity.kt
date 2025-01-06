package com.example.myapplication

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.icu.util.TimeZone
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // Khai báo ngày tháng hiện tại
    val today = Calendar.getInstance(TimeZone.getDefault())

    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.textTime.text = String.format("%02d:%02d", today.get(Calendar.HOUR_OF_DAY), today.get(Calendar.MINUTE))

        // set lại thời gian khi click vào button time
        binding.btnTime.setOnClickListener {
            //TimePicker
            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                binding.textTime.text = String.format("%02d:%02d", hourOfDay, minute)
            }, today.get(Calendar.HOUR_OF_DAY), today.get(Calendar.MINUTE), true).show()
        }

        //set lại thời gian khi click vào button date
        binding.btnDate.setOnClickListener {
            //DatePicker
            DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    binding.textDate.text =
                        String.format("%02d/%02d/%d", dayOfMonth, month + 1, year)
                },
                today.get(Calendar.YEAR),
                today.get(Calendar.MONTH),
                today.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

    }
}