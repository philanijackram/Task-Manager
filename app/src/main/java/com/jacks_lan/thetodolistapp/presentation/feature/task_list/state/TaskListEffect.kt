package com.jacks_lan.thetodolistapp.presentation.feature.task_list.state

sealed class TaskListEffect {
    object LoadTasks : TaskListEffect()
    data class ShowError(val message: String) : TaskListEffect()
    data class NavigateToTaskDetail(val taskId: Int) : TaskListEffect()
    object NavigateToAddTask : TaskListEffect()

}