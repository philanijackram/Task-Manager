package com.jacks_lan.thetodolistapp.utils

import com.jacks_lan.thetodolistapp.domain.model.TaskItem

object DummyData {

    val dummyTasks = listOf(
        TaskItem(
            id = 1,
            title = "Study Compose",
            description = "Study How i can optimise recomposition",
            image = null,
            dueDate = "20-10-2025",
            items = listOf("State", "Composable", "Composition")
        ),
        TaskItem(
            id = 2,
            title = "Finish Off-line Mode",
            description = "Finish Off-line Mode in the app and make it work",
            image = null,
            dueDate = "25-10-2025",
            items = listOf("Dao", "Entity", "Database")
        ),
        TaskItem(
            id = 3,
            title = "Add Navigation",
            description = "Make the app navigation work",
            image = null,
            dueDate = "26-10-2025",
            items = listOf("Navigation", "Navigation Controller", "Navigation Graph")
        ),
        TaskItem(
            id = 4,
            title = "Add Unit Tests",
            description = "Add Unit Tests to the app",
            image = null,
            dueDate = "27-10-2025",
            items = listOf("Unit Tests", "JUnit", "Mockito")
        ),
        TaskItem(
            id = 5,
            title = "Add Dependency Injection",
            description = "Add Dependency Injection to the app",
            image = null,
            dueDate = "28-10-2025",
            items = listOf("Dependency Injection", "Hilt", "Dagger")
        ),
        TaskItem(
            id = 6,
            title = "Add Security",
            description = "Add Security to the app",
            image = null,
            dueDate = "29-10-2025",
            items = listOf("Security", "Encryption", "Authentication")
        ),
        TaskItem(
            id = 7,
            title = "Add Analytics",
            description = "Add Analytics to the app",
            image = null,
            dueDate = "30-10-2025",
            items = listOf("Analytics", "Firebase", "Amplitude")
        )
    )
}