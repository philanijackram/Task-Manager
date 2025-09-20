package com.jacks_lan.thetodolistapp.presentation.feature.task_detail.state

sealed class TaskDetailEffect {
    data class ShowError(val message: String) : TaskDetailEffect()
    object NavigateBack : TaskDetailEffect()
}