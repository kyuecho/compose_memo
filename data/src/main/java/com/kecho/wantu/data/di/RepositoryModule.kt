package com.kecho.wantu.data.di

import com.kecho.wantu.data.repository.TodoLocalDataSource
import com.kecho.wantu.data.repository.TodoRepositoryImpl
import com.kecho.wantu.domain.repository.TodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideTodoRepository(localDataSource: TodoLocalDataSource) : TodoRepository {
        return TodoRepositoryImpl(localDataSource)
    }
}