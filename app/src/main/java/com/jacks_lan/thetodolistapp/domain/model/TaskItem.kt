package com.jacks_lan.thetodolistapp.domain.model

data class TaskItem(
    val id: Int,
    val title: String,
    val description: String,
    val image: String?,
    val dueDate: String,
    val items: List<String>
)