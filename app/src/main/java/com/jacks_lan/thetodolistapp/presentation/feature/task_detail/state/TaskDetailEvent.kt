package com.jacks_lan.thetodolistapp.presentation.feature.task_detail.state

sealed class TaskDetailEvent {
    data class LoadTask(val taskId: Int) : TaskDetailEvent()
    object OnBackArrowClick : TaskDetailEvent()
}