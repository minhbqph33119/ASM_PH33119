package com.example.asm_ph33119.data

import androidx.annotation.DrawableRes

data class Product (val id: Int, val name: String, val price: Double, val image: String, var isSelected: Boolean = false) {
}
data class Products (val id: Int, val name: String, val price: Double,@DrawableRes val image: Int, var isSelected: Boolean = false) {
}