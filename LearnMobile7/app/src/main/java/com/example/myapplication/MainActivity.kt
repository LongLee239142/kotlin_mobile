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
        // handler when click on button hobby
        binding.btnChoose.setOnClickListener{
            handlerChooseHobbies()
        }
        binding.btnConfirm.setOnClickListener{
            handlerConfirm()
        }
    }

    private fun handlerConfirm() {
        var s:String =""
        if(binding.radMale.isChecked){
            s += binding.radMale.text.toString()
            Toast.makeText(this, "You chosen $s",Toast.LENGTH_SHORT).show()

        }else if(binding.radFemale.isChecked){
            s += binding.radFemale.text.toString()
            Toast.makeText(this, "You chosen $s",Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this,"You must be choose ",Toast.LENGTH_SHORT).show()
        }

    }

    private fun handlerChooseHobbies() {
        var s:String =""
        val checkBoxes = listOf(
            binding.chListenMussic,
            binding.chWorkDate,
            binding.chPlaySoccer,
            binding.chPlayGame,
            binding.chWatchMovie
        )
        for (checkBox in checkBoxes) {
            if (checkBox.isChecked) {
                s += checkBox.text.toString() + "\n"
            }
        }
        binding.edtHobbies.setText(s)
    }
}