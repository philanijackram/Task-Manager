package com.jacks_lan.thetodolistapp.domain.use_case

import com.jacks_lan.thetodolistapp.data.repository.TaskRepository
import javax.inject.Inject

class GetTaskByIdUseCase  @Inject constructor(
    val taskRepository: TaskRepository
) {
    suspend operator fun invoke(taskID: Int) {
        taskRepository.getTaskById(taskID)
    }
}