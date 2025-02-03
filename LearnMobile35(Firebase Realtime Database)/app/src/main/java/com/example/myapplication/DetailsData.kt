package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityDetailsDataBinding
import com.google.firebase.database.FirebaseDatabase


class DetailsData : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailsDataBinding.inflate(layoutInflater)
        setContentView(binding.root) // Chỉ sử dụng binding.root
        setValueToView()
        binding.btnDelete.setOnClickListener {
            deleteUserById(intent.getStringExtra("empId").toString())
        }
    }

    private fun deleteUserById(id: String) {
        val dbRef = FirebaseDatabase.getInstance().getReference("Employees").child(id)
        val mTask = dbRef.removeValue()
        mTask.addOnSuccessListener {
            Toast.makeText(this, "Employee have deleted success", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@DetailsData, FetchData::class.java)
            finish()
            startActivity(intent)
        }.addOnFailureListener { err ->
            Toast.makeText(this,"Delete erro ${err.message}",Toast.LENGTH_SHORT).show()
        }

    }

    private fun setValueToView() {
        // Gán dữ liệu từ intent vào các TextView
        binding.textEmpId.text = intent.getStringExtra("empId")
        binding.textEmpName.text = intent.getStringExtra("empName")
        binding.textEmpAge.text = intent.getStringExtra("empAge")
        binding.textEmpSalary.text = intent.getStringExtra("empSalary")
    }
}
