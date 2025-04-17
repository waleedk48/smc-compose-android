package com.servicemycar.android.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


fun Long.toDate_dd_mm_yyyy(): String {
     val format = SimpleDateFormat("dd/MM/yyyy",Locale.getDefault())
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this
    return format.format(calendar.time)
 }

@SuppressLint("DefaultLocale")
fun Long.secondsToMM_SS():String{
    val minutes = this /60
    val seconds = this % 60
    return String.format("%02d",minutes) +" : "+ String.format("%02d", seconds)
}