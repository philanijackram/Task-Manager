package com.jacks_lan.thetodolistapp.presentation.feature.task_list.state

sealed class TaskListEvent {
    object LoadTasks: TaskListEvent()
    data class OnTaskClick(val taskId: Int) : TaskListEvent()
    data class OnDeleteTaskClick(val taskId: Int) : TaskListEvent()
    object OnAddTaskClick : TaskListEvent()

}