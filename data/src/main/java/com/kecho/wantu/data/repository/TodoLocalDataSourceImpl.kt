package com.kecho.wantu.data.repository

import com.kecho.wantu.data.local.TodoDatabase
import com.kecho.wantu.data.model.Todo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TodoLocalDataSourceImpl @Inject constructor(
    private val todoDatabase: TodoDatabase
) : TodoLocalDataSource {

    override fun getTodo(): Flow<List<Todo>> = todoDatabase.todoDao().todos()

    override fun searchTodos(query: String): Flow<List<Todo>>? = todoDatabase.todoDao().searchTodos(query)

    override suspend fun addTodo(todo: Todo) = todoDatabase.todoDao().insert(todo)

    override suspend fun updateTodo(todo: Todo) = todoDatabase.todoDao().update(todo)

    override suspend fun deleteTodo(todo: Todo) = todoDatabase.todoDao().delete(todo)
}