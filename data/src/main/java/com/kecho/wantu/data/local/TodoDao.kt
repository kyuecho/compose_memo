package com.kecho.wantu.data.local

import androidx.room.*
import com.kecho.wantu.data.model.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo ORDER BY date DESC")
    fun todos(): Flow<List<Todo>>

    @Query("SELECT * FROM todo WHERE title LIKE '%' || :query || '%'")
    fun searchTodos(query : String): Flow<List<Todo>>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: Todo)

    @Update
    suspend fun update(entity: Todo)

    @Delete
    suspend fun delete(entity: Todo)
}