package com.kecho.wantu.data.repository

import com.kecho.wantu.data.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoLocalDataSource {
    fun getTodo() : Flow<List<Todo>>
    fun searchTodos(query : String) : Flow<List<Todo>>?
    suspend fun addTodo(todo : Todo)
    suspend fun updateTodo(todo : Todo)
    suspend fun deleteTodo(todo : Todo)
}