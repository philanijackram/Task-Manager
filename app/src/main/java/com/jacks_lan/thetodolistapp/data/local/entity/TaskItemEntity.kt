package com.jacks_lan.thetodolistapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.jacks_lan.thetodolistapp.data.local.Converters
import com.jacks_lan.thetodolistapp.domain.model.TaskItem

@Entity(tableName = "tasks")
data class TaskItemEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String,
    val image: String? = null,
    val dueDate: String,
    val items: List<String> = emptyList()
)

fun TaskItemEntity.toTaskItem(): TaskItem {
    return TaskItem(
        id = id,
        title = title,
        description = description,
        image = image,
        dueDate = dueDate,
        items = items
    )
}