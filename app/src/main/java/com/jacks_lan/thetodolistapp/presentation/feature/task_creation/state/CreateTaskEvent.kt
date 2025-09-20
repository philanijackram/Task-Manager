package com.jacks_lan.thetodolistapp.presentation.feature.task_creation.state

import com.jacks_lan.thetodolistapp.domain.model.TaskItem

sealed class CreateTaskEvent() {
    data class OnTitleChange(val title: String) : CreateTaskEvent()
    data class OnDescriptionChange(val description: String) : CreateTaskEvent()
    data class OnDateChange(val date: String) : CreateTaskEvent()
    class OnCreateTask(val taskItem: TaskItem) :
        CreateTaskEvent()

    object OnBackClicked : CreateTaskEvent()
}