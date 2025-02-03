package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityInsertDataBinding
import com.example.myapplication.model.EmployeeModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class InsertData : AppCompatActivity() {
    private lateinit var binding: ActivityInsertDataBinding
    private lateinit var dbRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_insert_data)
        dbRef = FirebaseDatabase.getInstance().getReference("Employees")
        binding = ActivityInsertDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //xử lý sự kiện khi click vào button shape
        binding.btnSave.setOnClickListener{
            saveEmployeeData()
        }
    }

    private fun saveEmployeeData() {
        val empName = binding.edtName.text.toString()
        val empAge = binding.edtAge.text.toString()
        val empSalary = binding.edtSalary.text.toString()
        //verify data
        if (empName.isEmpty()){
            binding.edtName.error ="Please enter your name"
            return
        }
        if (empAge.isEmpty()){
            binding.edtAge.error ="Please enter your age"
            return
        }
        if (empSalary.isEmpty()){
            binding.edtSalary.error ="Please enter your salary"
            return
        }

        //Đẩy dữ liệu lên database
        val empId = dbRef.push().key!!
        val employee = EmployeeModel(empId,empName,empAge,empSalary)
        dbRef.child(empId).setValue(employee)
            .addOnCompleteListener {
                Toast.makeText(this,"Data insert success", Toast.LENGTH_SHORT).show()
                binding.edtName.setText("")
                binding.edtAge.setText("")
                binding.edtSalary.setText("")
            }
            .addOnFailureListener { err ->
                Toast.makeText(this,"Error ${err.message}",Toast.LENGTH_SHORT).show()
            }
    }
}