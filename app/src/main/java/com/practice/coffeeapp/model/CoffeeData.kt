package com.practice.coffeeapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoffeeData(
    val coffeeImg:Int,
    val coffeeName:String,
    val coffeePrice:String
) : Parcelable
