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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jacks_lan.thetodolistapp.domain.model.TaskItem
import com.jacks_lan.thetodolistapp.presentation.components.PrimaryButton
import com.jacks_lan.thetodolistapp.presentation.components.SecondaryButton
import com.jacks_lan.thetodolistapp.presentation.components.StandardDatePicker
import com.jacks_lan.thetodolistapp.presentation.components.StandardTextField
import com.jacks_lan.thetodolistapp.presentation.feature.task_creation.state.CreateTaskEffect
import com.jacks_lan.thetodolistapp.presentation.feature.task_creation.state.CreateTaskEvent
import com.jacks_lan.thetodolistapp.presentation.feature.task_creation.view_model.CreateTaskViewModel
import com.jacks_lan.thetodolistapp.utils.DummyData.dummyTasks

@Preview
@Composable
fun CreateTaskScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit = {},
    viewModel: CreateTaskViewModel = hiltViewModel()
) {

    val uiState = viewModel.uiState

    LaunchedEffect(true) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is CreateTaskEffect.NavigateBack -> {
                    onNavigateBack()
                }

                is CreateTaskEffect.ShowSnackbar -> {}
            }
        }

    }

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
                        viewModel.onEvent(
                            CreateTaskEvent.OnCreateTask(
                                TaskItem(
                                    title = uiState.title,
                                    description = uiState.description,
                                    dueDate = uiState.date
                                )
                            )
                        )
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
                    value = uiState.title,
                    onValueChange = {
                        viewModel.onEvent(CreateTaskEvent.OnTitleChange(it))
                    },
                    label = "Title"
                )
            }

            item {
                StandardTextField(
                    value = uiState.description,
                    onValueChange = { viewModel.onEvent(CreateTaskEvent.OnDescriptionChange(it)) },
                    label = "Description"
                )
            }

            item {
                StandardDatePicker(
                    onDateSelected = {
                        viewModel.onEvent(CreateTaskEvent.OnDateChange(it))
                    }
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
