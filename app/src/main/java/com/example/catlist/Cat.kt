package com.example.catlist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cat(
    val breed: String,
    val description: String,
    val photo: Int,
    val personality: String,
    val care: String,
) : Parcelable