package com.jacks_lan.thetodolistapp.presentation.feature.task_detail.state

import com.jacks_lan.thetodolistapp.domain.model.TaskItem

data class TaskDetailUiState(
    val task: TaskItem? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)