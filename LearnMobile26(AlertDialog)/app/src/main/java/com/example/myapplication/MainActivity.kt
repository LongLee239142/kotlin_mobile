package com.example.myapplication

import android.content.DialogInterface
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
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
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnExit.setOnClickListener{
            val dialog =AlertDialog.Builder(this)
            dialog.apply {
                //tiêu đề của thông báo
                setTitle("Comfirm Window")
                //nội dung thông
                setMessage("Do you want to close this app?")
                // nút phủ định
                setNegativeButton("No"){ dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.dismiss()
                }

                //nút khẳng định
                setPositiveButton("Yes"){ dialogInterface: DialogInterface, i: Int ->
                    finish()
                }
                // Ngăn không cho đóng dialog khi click ra ngoài
                setCancelable(false)

            }
            dialog.show()
        }
    }
}