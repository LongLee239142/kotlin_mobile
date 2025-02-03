package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.FetchDataAdapter
import com.example.myapplication.databinding.ActivityFetchDataBinding
import com.example.myapplication.model.EmployeeModel
import com.google.firebase.database.DatabaseReference
import android.view.View
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FetchData : AppCompatActivity() {
    private lateinit var binding : ActivityFetchDataBinding
    private lateinit var listData : ArrayList<EmployeeModel>
    private lateinit var dbRef: DatabaseReference
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fetch_data)
        binding = ActivityFetchDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
        listData = arrayListOf<EmployeeModel>()
        getInformationEmployee()

    }

    private fun getInformationEmployee() {
        binding.recyclerView.visibility = View.GONE
        binding.textLoading.visibility = View.VISIBLE
        dbRef = FirebaseDatabase.getInstance().getReference("Employees")
        dbRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                listData.clear()
                if(snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(EmployeeModel::class.java)
                        if (empData != null) {
                            listData.add(empData)
                        }
                    }
                    val mAdapter = FetchDataAdapter(listData)
                    binding.recyclerView.adapter = mAdapter
                    //code lắng nghe sự kiện lên item
                    mAdapter.setOnItemClickListener(object : FetchDataAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {
                            val intent = Intent(this@FetchData,DetailsData::class.java)
                            intent.putExtra("empId",listData[position].emId)
                            intent.putExtra("empName",listData[position].empName)
                            intent.putExtra("empAge",listData[position].empAge)
                            intent.putExtra("empSalary",listData[position].empSalary)
                            startActivity(intent)
                        }

                    })
                    binding.recyclerView.visibility = View.VISIBLE
                    binding.textLoading.visibility = View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}