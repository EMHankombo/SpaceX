package com.example.android.spacex.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

object Utilities {

    @SuppressLint("SimpleDateFormat")
    fun getDateOnly(date: String): String{
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val parsedDate = sdf.parse(date)
        return SimpleDateFormat("dd-MM-yyyy").format(parsedDate)
    }



}