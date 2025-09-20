package com.jacks_lan.thetodolistapp.presentation.feature.task_creation.state

sealed class CreateTaskEffect {
    data class ShowSnackbar(val message: String) : CreateTaskEffect()
    object NavigateBack : CreateTaskEffect()
}