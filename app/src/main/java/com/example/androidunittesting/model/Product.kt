package com.example.androidunittesting.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    val category: String,
    val description: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
){
    override fun toString(): String {
        return "Product(category='$category', description='$description', id=$id, image='$image', price=$price, title='$title')"
    }
}