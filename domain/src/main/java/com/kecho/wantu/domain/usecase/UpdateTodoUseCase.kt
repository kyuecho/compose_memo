package com.kecho.wantu.domain.usecase

import com.kecho.wantu.domain.model.TodoModel
import com.kecho.wantu.domain.repository.TodoRepository
import javax.inject.Inject

class UpdateTodoUseCase @Inject constructor(private val repository: TodoRepository) {
    suspend fun execute(todo : TodoModel)  = repository.updateTodo(todo)
}