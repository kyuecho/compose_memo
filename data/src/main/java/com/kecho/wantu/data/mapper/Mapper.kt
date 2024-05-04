package com.kecho.wantu.data.mapper

import com.kecho.wantu.data.model.Todo
import com.kecho.wantu.domain.model.TodoModel

fun Todo.toDomainModel(): TodoModel {
    return TodoModel(uid = uid, memo = title, isDone = isDone, date = date)
}

fun TodoModel.toDataModel(): Todo {
    return Todo(uid = uid, title = memo, isDone = isDone, date = date)
}