package com.kecho.wantu.data.di

import android.content.Context
import androidx.room.Room
import com.kecho.wantu.data.local.TodoDatabase
import com.kecho.wantu.data.repository.TodoLocalDataSource
import com.kecho.wantu.data.repository.TodoLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class LocalDataModule {
    @Provides
    @Singleton
    fun provideTodoDatabase(@ApplicationContext context: Context) : TodoDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            TodoDatabase::class.java,
            "todo-db"
        ).build()

    @Provides
    @Singleton
    fun provideTodoLocalDataSource(todoDatabase: TodoDatabase) : TodoLocalDataSource {
        return TodoLocalDataSourceImpl(todoDatabase)
    }
}