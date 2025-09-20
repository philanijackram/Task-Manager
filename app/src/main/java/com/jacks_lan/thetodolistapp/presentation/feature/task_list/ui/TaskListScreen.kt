package com.jacks_lan.thetodolistapp.presentation.feature.task_list.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jacks_lan.thetodolistapp.domain.model.TaskItem
import com.jacks_lan.thetodolistapp.presentation.components.MainScaffold
import com.jacks_lan.thetodolistapp.presentation.feature.task_list.state.TaskListEffect
import com.jacks_lan.thetodolistapp.presentation.feature.task_list.view_model.TaskListViewModel
import com.jacks_lan.thetodolistapp.utils.DummyData.dummyTasks

@Composable
fun TaskListScreen(
    modifier: Modifier = Modifier,
    viewModel: TaskListViewModel = hiltViewModel(),
    onCardClick: (Int) -> Unit = {},
    onFabClick: () -> Unit = {}
) {

    MainScaffold(
        onFabClick = onFabClick,
        title = "Task Manager",
        showBackArrow = false,

    ) {
        val uiState = viewModel.uiState

        LaunchedEffect(key1 = true) {
            viewModel.effect.collect { effect ->
                when (effect) {
                    is TaskListEffect.LoadTasks -> viewModel.getAllTasks()

                    TaskListEffect.NavigateToAddTask -> {
                        onFabClick()
                    }

                    is TaskListEffect.NavigateToTaskDetail -> {
                        onCardClick(effect.taskId)
                    }

                    is TaskListEffect.ShowError -> {}
                }
            }
        }

        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                Text("Item List", style = MaterialTheme.typography.headlineMedium)
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            items(uiState.tasks.size) {
                TaskItem(
                    uiState.tasks[it],
                    onCardClick = { taskId ->
                        onCardClick(taskId)
                    },
                    onDeleteClick = { taskId ->
                        viewModel.deleteTask(taskId)
                    }
                )
            }
        }
    }


}

@Preview
@Composable
fun TaskItem(
    item: TaskItem = dummyTasks[0],
    onCardClick: (Int) -> Unit = {},
    onDeleteClick: (Int) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable {
                onCardClick(item.id)
            }
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = item.title,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterStart),
                style = MaterialTheme.typography.bodyLarge
            )

            IconButton(
                onClick = { onDeleteClick(item.id) },
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterEnd),
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete"
                )
            }
        }
    }
}