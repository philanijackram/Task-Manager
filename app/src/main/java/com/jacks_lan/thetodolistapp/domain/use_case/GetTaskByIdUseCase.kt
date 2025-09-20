package com.jacks_lan.thetodolistapp.domain.use_case

import com.jacks_lan.thetodolistapp.data.local.entity.toTaskItem
import com.jacks_lan.thetodolistapp.data.repository.TaskRepository
import com.jacks_lan.thetodolistapp.domain.model.TaskItem
import javax.inject.Inject

class GetTaskByIdUseCase @Inject constructor(
    val taskRepository: TaskRepository
) {
    suspend operator fun invoke(taskID: Int): TaskItem? {
        return taskRepository.getTaskById(taskID)?.toTaskItem()
    }
}