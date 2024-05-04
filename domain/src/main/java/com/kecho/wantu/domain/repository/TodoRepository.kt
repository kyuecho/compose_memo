package com.kecho.wantu.domain.repository

import com.kecho.wantu.domain.model.TodoModel
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    fun getTodo() : Flow<List<TodoModel>>
    fun searchTodos(query : String) : Flow<List<TodoModel>>
    suspend fun addTodo(todo : TodoModel)
    suspend fun updateTodo(todo : TodoModel)
    suspend fun deleteTodo(todo : TodoModel)
}