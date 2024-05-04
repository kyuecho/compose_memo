package com.kecho.wantu.domain.di

import com.kecho.wantu.domain.repository.TodoRepository
import com.kecho.wantu.domain.usecase.AddTodoUseCase
import com.kecho.wantu.domain.usecase.DeleteTodoUseCase
import com.kecho.wantu.domain.usecase.GetTodoUseCase
import com.kecho.wantu.domain.usecase.SearchTodosUseCase
import com.kecho.wantu.domain.usecase.UpdateTodoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideAddTodoUseCase(todoRepository: TodoRepository): AddTodoUseCase {
        return AddTodoUseCase(todoRepository)
    }

    @Provides
    @Singleton
    fun provideDeleteTodoUseCase(todoRepository: TodoRepository): DeleteTodoUseCase {
        return DeleteTodoUseCase(todoRepository)
    }

    @Provides
    @Singleton
    fun provideGetTodoUseCase(todoRepository: TodoRepository): GetTodoUseCase {
        return GetTodoUseCase(todoRepository)
    }

    @Provides
    @Singleton
    fun provideSearchTodosByIdUseCase(todoRepository: TodoRepository): SearchTodosUseCase {
        return SearchTodosUseCase(todoRepository)
    }

    @Provides
    @Singleton
    fun provideUpdateTodoUseCase(todoRepository: TodoRepository): UpdateTodoUseCase {
        return UpdateTodoUseCase(todoRepository)
    }
}