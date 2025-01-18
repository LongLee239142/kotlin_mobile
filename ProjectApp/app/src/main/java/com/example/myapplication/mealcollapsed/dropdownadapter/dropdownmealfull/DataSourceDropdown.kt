package com.example.myapplication.mealcollapsed.dropdownadapter.dropdownmealfull

import com.google.android.material.checkbox.MaterialCheckBox.CheckedState

data class DataSourceDropdown(val imageProduct: Int, val tilteName: String, val price: String? = null, var isCheckedState: Boolean = false) {
}