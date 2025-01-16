package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.CustomDialogBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var dialog: AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnClick.setOnClickListener {
//            showDialog()
            showDialogBinding()
        }
    }

    private fun showDialogBinding() {
        var build = AlertDialog.Builder(this,R.style.LongLeecustom)
        val dialogBinding = CustomDialogBinding.inflate(layoutInflater)
        build.setView(dialogBinding.root)
        val dialog = build.create()
        dialogBinding.btnClose.setOnClickListener {
            dialog.dismiss()
        }
        dialogBinding.btnJoin.setOnClickListener {
            Toast.makeText(this, "You Have joined success", Toast.LENGTH_SHORT).show()
        }
        // Ngăn không cho đóng dialog khi click ra ngoài
        dialog.setCancelable(false)
        dialog.show()
    }

    private fun showDialog() {
        var build = AlertDialog.Builder(this,R.style.LongLeecustom)
        val view = layoutInflater.inflate(R.layout.custom_dialog, null)
        build.setView(view)
        val btnClose = view.findViewById<ImageButton>(R.id.btnClose)
        btnClose.setOnClickListener {
            dialog.dismiss()
        }
        val btnJoin = view.findViewById<Button>(R.id.btnJoin)
        btnJoin.setOnClickListener {
            Toast.makeText(this, "You Have joined success", Toast.LENGTH_SHORT).show()
        }
        // Ngăn không cho đóng dialog khi click ra ngoài
        dialog.setCancelable(false)
        dialog = build.create()
        dialog.show()
    }
}