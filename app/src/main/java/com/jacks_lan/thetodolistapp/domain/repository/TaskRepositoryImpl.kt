package com.jacks_lan.thetodolistapp.domain.repository

import com.jacks_lan.thetodolistapp.data.local.dao.TaskDao
import com.jacks_lan.thetodolistapp.data.local.entity.TaskItemEntity
import com.jacks_lan.thetodolistapp.data.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val taskDao: TaskDao
): TaskRepository {
    override suspend fun insertTask(task: TaskItemEntity) {
        taskDao.insertTask(task)
    }

    override suspend  fun getAllTasks(): Flow<List<TaskItemEntity>> {
       return taskDao.getAllTasks()
    }

    override suspend fun getTaskById(id: Int): TaskItemEntity? {
       return taskDao.getTaskById(id)
    }

    override suspend fun updateTask(task: TaskItemEntity) {
        taskDao.updateTask(task)
    }

    override suspend fun deleteTask(taskId: Int) {
        taskDao.deleteTask(taskId)
    }

}