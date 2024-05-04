package com.kecho.wantu.domain.model

import java.util.Calendar

data class TodoModel(
    var uid: Int = 0,
    val memo: String,
    val date: Long = Calendar.getInstance().timeInMillis,
    val isDone: Boolean = false,
)