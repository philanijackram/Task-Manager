package com.jacks_lan.thetodolistapp.domain.use_case

import com.jacks_lan.thetodolistapp.data.repository.TaskRepository
import com.jacks_lan.thetodolistapp.domain.model.TaskItem
import com.jacks_lan.thetodolistapp.domain.model.toTaskItemEntity
import javax.inject.Inject

class DeleteTaskUseCase  @Inject constructor(
    val taskRepository: TaskRepository
) {
    suspend operator fun invoke(itemId: Int) {
        taskRepository.deleteTask(
            itemId

        )
    }
}