package com.kecho.wantu.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kecho.wantu.data.model.Todo

@Database(entities = [Todo::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}