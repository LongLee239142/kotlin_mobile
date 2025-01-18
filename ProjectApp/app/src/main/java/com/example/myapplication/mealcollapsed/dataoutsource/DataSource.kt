package com.example.myapplication.mealcollapsed.dataoutsource

import com.example.myapplication.mealcollapsed.dropdownadapter.dropdownmealfull.DataSourceDropdown

data class DataSource(
    val tilteName: String,
    val note: String? = null,
    val listDropdown: List<DataSourceDropdown>? = null
) {
}