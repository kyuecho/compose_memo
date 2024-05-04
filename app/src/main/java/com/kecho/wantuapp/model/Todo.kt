package com.kecho.wantuapp.model

import java.util.*

data class Todo(
    val title: String,
    val date: Long = Calendar.getInstance().timeInMillis,
    val isDone: Boolean = false,
) {
    var uid: Int = 0 // unique id
}