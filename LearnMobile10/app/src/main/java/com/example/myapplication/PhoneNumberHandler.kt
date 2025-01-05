package com.example.myapplication

import android.content.Context
import android.widget.ArrayAdapter
import com.example.myapplication.databinding.ActivityMainBinding

class PhoneNumberHandler(
    private val context: Context,
    private val binding: ActivityMainBinding,
    private val list: MutableList<String>
) {

    fun setupUI() {
        // Hiển thị danh sách số điện thoại ban đầu
        binding.listPhoneNumber.adapter = ArrayAdapter(
            context, android.R.layout.simple_list_item_1, list
        )
    }

    fun handleEvents() {
        binding.btnSave.setOnClickListener {
            handleSave()
        }
    }

    private fun handleSave() {
        val phoneNumber = binding.edtPhoneNumber.text.toString()
        if (phoneNumber.isNotBlank()) {
            list.add(phoneNumber)
            binding.edtPhoneNumber.setText("")
//            binding.edtPhoneNumber.requestFocus() // Đưa con trỏ vào ô nhập liệu
            updateListView()
        }
    }

    private fun updateListView() {
        binding.listPhoneNumber.adapter = ArrayAdapter(
            context, android.R.layout.simple_list_item_1, list
        )
    }
}
