package com.jacks_lan.thetodolistapp.presentation.feature.task_list.state

import com.jacks_lan.thetodolistapp.domain.model.TaskItem

data class TaskListUiState(
    val tasks: List<TaskItem> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)