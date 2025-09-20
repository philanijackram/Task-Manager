package com.jacks_lan.thetodolistapp.presentation.feature.task_creation.state

data class CreateTaskUiState(
    val title: String = "",
    val description: String = "",
    val date: String = "",
    val image: String? = null,
    val items: List<String> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)