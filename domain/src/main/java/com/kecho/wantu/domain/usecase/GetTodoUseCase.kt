package com.kecho.wantu.domain.usecase

import com.kecho.wantu.domain.model.TodoModel
import com.kecho.wantu.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTodoUseCase @Inject constructor(private val repository: TodoRepository) {
    fun execute(): Flow<List<TodoModel>> = repository.getTodo()
}