package com.kecho.wantuapp.ui.viewmodel

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.kecho.wantu.domain.model.TodoModel
import com.kecho.wantu.domain.usecase.AddTodoUseCase
import com.kecho.wantu.domain.usecase.DeleteTodoUseCase
import com.kecho.wantu.domain.usecase.GetTodoUseCase
import com.kecho.wantu.domain.usecase.SearchTodosUseCase
import com.kecho.wantu.domain.usecase.UpdateTodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    application: Application,
    private val addTodoUseCase: AddTodoUseCase,
    private val deleteTodoUseCase: DeleteTodoUseCase,
    private val updateTodoUseCase: UpdateTodoUseCase,
    private val getTodoUseCase: GetTodoUseCase,
    private val searchTodosUseCase: SearchTodosUseCase
) : AndroidViewModel(application) {

    private val _items = mutableStateOf(emptyList<TodoModel>())
    val items: State<List<TodoModel>> = _items

    init {
        viewModelScope.launch {
            getTodoUseCase.execute()
                .collect { todos ->
                    _items.value = todos
                }
        }
    }

    fun searchTodos(query: String) = viewModelScope.launch {
        searchTodosUseCase.execute(query)
            .collect { todos ->
                _items.value = todos
            }
    }

    fun addTodo(text: String) = viewModelScope.launch {
        addTodoUseCase.execute(TodoModel(memo = text))
    }

    fun updateTodo(text: String, todoModel: TodoModel) = viewModelScope.launch {
        val todo = _items.value.find { todo -> todo.uid == todoModel.uid }
        todo?.let {
            viewModelScope.launch {
                updateTodoUseCase.execute(it.copy(memo = text))
            }
        }
    }

    fun updateIsDone(id: Int) {
        val todo = _items.value.find { todo -> todo.uid == id }
        todo?.let {
            viewModelScope.launch {
                updateTodoUseCase.execute(it.copy(isDone = !it.isDone))
            }
        }
    }

    fun deleteTodo(index: Int) {
        val todo = _items.value.find { todo -> todo.uid == index }
        todo?.let {
            viewModelScope.launch {
                deleteTodoUseCase.execute(it)
            }
        }
    }
}