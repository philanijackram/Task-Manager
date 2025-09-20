package com.jacks_lan.thetodolistapp.domain.model

import com.jacks_lan.thetodolistapp.data.local.entity.TaskItemEntity

data class TaskItem(
    val id: Int,
    val title: String,
    val description: String,
    val image: String? = null,
    val dueDate: String,
    val items: List<String> = emptyList()
)

fun TaskItem.toTaskItemEntity(): TaskItemEntity {
    return TaskItemEntity(
        id = id,
        title = title,
        description = description,
        image = image,
        dueDate = dueDate,
        items = items
    )
}