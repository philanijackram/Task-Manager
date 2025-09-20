package com.jacks_lan.thetodolistapp.presentation.feature.task_creation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jacks_lan.thetodolistapp.domain.model.TaskItem
import com.jacks_lan.thetodolistapp.presentation.components.PrimaryButton
import com.jacks_lan.thetodolistapp.presentation.components.SecondaryButton
import com.jacks_lan.thetodolistapp.presentation.components.StandardDatePicker
import com.jacks_lan.thetodolistapp.presentation.components.StandardTextField
import com.jacks_lan.thetodolistapp.utils.DummyData.dummyTasks

@Preview
@Composable
fun CreateTaskScreen(modifier: Modifier = Modifier) {
    val title = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    val date = remember { mutableStateOf("") }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                SecondaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Add Image"
                )
                PrimaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Create Task",
                    onClick = {
                        createTask(title.value, description.value, date.value)
                    }
                )
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            item {
                StandardTextField(
                    value = title.value,
                    onValueChange = { title.value = it },
                    label = "Title"
                )
            }

            item {
                StandardTextField(
                    value = description.value,
                    onValueChange = { description.value = it },
                    label = "Description"
                )
            }

            item {
                StandardDatePicker(
                    onDateSelected = { date.value = it }
                )
            }
        }
    }
}

fun createTask(title: String, description: String, date: String) {
    if (title.isBlank() || description.isBlank() || date.isBlank()) {
        return
    }
    val lastId = dummyTasks.lastOrNull()?.id ?: 0
    val newId = lastId + 1

    dummyTasks.add(
        TaskItem(
            id = newId,
            title = title,
            description = description,
            dueDate = date
        )
    )
}
