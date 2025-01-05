package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

        val edtEnterA = findViewById<EditText>(R.id.edtEnterA)
        val edtEnterB = findViewById<EditText>(R.id.edtEnterB)
        val edtResult = findViewById<EditText>(R.id.edtResult)
        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)
        val btnPressLong = findViewById<Button>(R.id.btnPressLong)
        val btnPress = findViewById<Button>(R.id.btnPress)
        val btnLogOut = findViewById<Button>(R.id.btnLogOut)

        val eventShare = View.OnClickListener {
            when (it) {
                btnPlus -> {
                    val A = edtEnterA.text.toString().toIntOrNull() ?: 0
                    val B = edtEnterB.text.toString().toIntOrNull() ?: 0
                    edtResult.setText((A + B).toString())
                }

                btnMultiply -> {
                    val A = edtEnterA.text.toString().toIntOrNull() ?: 0
                    val B = edtEnterB.text.toString().toIntOrNull() ?: 0
                    edtResult.setText((A * B).toString())
                }

                btnDivide -> {
                    val A = edtEnterA.text.toString().toIntOrNull() ?: 0
                    val B = edtEnterB.text.toString().toIntOrNull() ?: 1
                    if (B != 0) {
                        edtResult.setText((A.toDouble() / B).toString())
                    } else {
                        Toast.makeText(this, "Không thể chia cho 0", Toast.LENGTH_SHORT).show()
                    }
                }

                btnReset -> {
                    edtEnterA.setText("")
                    edtEnterB.setText("")
                    edtResult.setText("")
                    Toast.makeText(this, "Đã xoá hết", Toast.LENGTH_LONG).show()
                }
                btnLogOut ->{
                    Toast.makeText(this, "Thanks For Used App", Toast.LENGTH_LONG).show()
                    finish()
                }
            }
        }

        btnPlus.setOnClickListener(eventShare)
        btnMultiply.setOnClickListener(eventShare)
        btnDivide.setOnClickListener(eventShare)
        btnReset.setOnClickListener(eventShare)
        btnLogOut.setOnClickListener(eventShare)
        val eventPressLong = View.OnLongClickListener {
            when (it) {
                btnPressLong -> {
                    Toast.makeText(this, "Đã xoá hết", Toast.LENGTH_LONG).show()
                    btnPressLong.visibility = View.GONE // hiden button
                    true
                }

                btnPress -> {
                    Toast.makeText(this, "Đã xoá hết", Toast.LENGTH_SHORT).show()
                    btnPress.visibility = View.GONE //hiden button
                    true
                }

                else -> {
                    true
                }
            }
        }
        btnPressLong.setOnLongClickListener(eventPressLong)
        btnPress.setOnLongClickListener(eventPressLong)

    }
}

