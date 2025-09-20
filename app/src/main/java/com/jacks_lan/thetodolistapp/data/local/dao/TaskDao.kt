package com.jacks_lan.thetodolistapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.jacks_lan.thetodolistapp.data.local.entity.TaskItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: TaskItemEntity)

    @Query("SELECT * FROM tasks")
    fun getAllTasks(): Flow<List<TaskItemEntity>>

    @Update
    suspend fun updateTask(task: TaskItemEntity)

    @Query("DELETE FROM tasks WHERE id = :taskId")
    suspend fun deleteTask(taskId: Int)

    @Query("SELECT * FROM tasks WHERE id = :taskId")
    suspend fun getTaskById(taskId: Int): TaskItemEntity

}