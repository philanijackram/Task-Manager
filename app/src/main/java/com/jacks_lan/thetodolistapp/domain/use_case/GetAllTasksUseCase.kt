package com.jacks_lan.thetodolistapp.domain.use_case

import com.jacks_lan.thetodolistapp.data.local.entity.toTaskItem
import com.jacks_lan.thetodolistapp.data.repository.TaskRepository
import com.jacks_lan.thetodolistapp.domain.model.TaskItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAllTasksUseCase @Inject constructor(
    val taskRepository: TaskRepository
) {
    suspend operator fun invoke() : Flow<List<TaskItem>> {
       return taskRepository.getAllTasks().map { taskList ->
           taskList.map { taskItemEntity ->
               taskItemEntity.toTaskItem()
           }
       }
    }
}