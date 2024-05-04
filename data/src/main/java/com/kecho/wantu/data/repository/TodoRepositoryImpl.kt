package com.kecho.wantu.data.repository

import com.kecho.wantu.data.mapper.toDataModel
import com.kecho.wantu.domain.model.TodoModel
import com.kecho.wantu.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(private val localDataSource: TodoLocalDataSource) :
    TodoRepository {
    override fun getTodo(): Flow<List<TodoModel>> {
        return localDataSource.getTodo().map { todos ->
            todos.map {
                TodoModel(
                    uid = it.uid,
                    date = it.date,
                    memo = it.title,
                    isDone = it.isDone
                )
            }.sortedByDescending { it.date }
        }
    }

    override suspend fun addTodo(todo: TodoModel) {
        localDataSource.addTodo(todo.toDataModel())
    }

    override suspend fun updateTodo(todo: TodoModel) {
        localDataSource.updateTodo(todo.toDataModel())
    }

    override suspend fun deleteTodo(todo: TodoModel) {
        localDataSource.deleteTodo(todo.toDataModel())
    }

    override fun searchTodos(query: String): Flow<List<TodoModel>> {
        return localDataSource.searchTodos(query)?.map { todos ->
            todos.map {
                TodoModel(
                    uid = it.uid,
                    date = it.date,
                    memo = it.title,
                    isDone = it.isDone
                )
            }.sortedByDescending { it.date }
        } ?: flowOf(emptyList())
    }
}