package com.example.myapplication.allCatergories

data class Category(
    val name: String,
    val imageRes: Int,
    val label: String? = null // "NEW" hoặc "FAVS", null nếu không có
)
