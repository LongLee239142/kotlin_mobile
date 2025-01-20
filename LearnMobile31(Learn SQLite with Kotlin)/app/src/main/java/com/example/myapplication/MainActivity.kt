package com.example.myapplication

import android.content.ContentValues
import android.os.Bundle
import android.widget.Toast
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
        var helper = MyDbHelper(applicationContext)
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT*FROM USERS_1", null)
        if(rs.moveToLast())
            Toast.makeText(applicationContext,rs.getString(1),Toast.LENGTH_SHORT).show()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Lắng nghe sự kiện click lên btnAdd
        binding.btnAdd.setOnClickListener{
            var cv = ContentValues()
            cv.put("USERNAME",binding.edtUserName.text.toString())
            cv.put("PWD",binding.edtPassword.text.toString())
            db.insert("USERS_1",null,cv)
            Toast.makeText(applicationContext,"Add successes",Toast.LENGTH_SHORT).show()
            binding.edtUserName.setText("")
            binding.edtPassword.setText("")
            binding.edtUserName.requestFocus()
        }

    }
}