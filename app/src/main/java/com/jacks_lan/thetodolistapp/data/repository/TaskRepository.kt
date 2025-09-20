package com.jacks_lan.thetodolistapp.data.repository

import com.jacks_lan.thetodolistapp.data.local.entity.TaskItemEntity
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    //   CREATE
    suspend fun insertTask(task: TaskItemEntity)
    //   READ
    suspend fun getAllTasks(): Flow<List<TaskItemEntity>>
    suspend fun getTaskById(id: Int): TaskItemEntity?

    //  UPDATE
    suspend fun updateTask(task: TaskItemEntity)

    //  DELETE
    suspend fun deleteTask(taskId: Int)
}