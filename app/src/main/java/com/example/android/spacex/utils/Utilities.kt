package com.example.android.spacex.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

object Utilities {

    @SuppressLint("SimpleDateFormat")
    fun getDateOnly(date: String): String {
        return try {
            val sdf = SimpleDateFormat("yyyy-MM-dd")
            val parsedDate = sdf.parse(date) ?: ""
            SimpleDateFormat("dd-MM-yyyy").format(parsedDate)
        } catch (e: Exception) {
            ""
        }

    }

    fun getDaysBetweenDates(date1: String, date2: String): Int {
        return try {
            val dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy")
            val firstDate = LocalDate.parse(getDateOnly(date1), dtf)
            val secondDate = LocalDate.parse(getDateOnly(date2), dtf)
            ChronoUnit.DAYS.between(firstDate, secondDate).toInt()
        } catch (e: Exception) {
            0
        }

    }
}