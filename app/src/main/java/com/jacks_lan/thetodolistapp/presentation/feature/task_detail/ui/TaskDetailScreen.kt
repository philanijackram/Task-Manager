package com.jacks_lan.thetodolistapp.presentation.feature.task_detail.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import com.jacks_lan.thetodolistapp.presentation.components.MainScaffold
import com.jacks_lan.thetodolistapp.presentation.feature.task_detail.state.TaskDetailEffect
import com.jacks_lan.thetodolistapp.presentation.feature.task_detail.state.TaskDetailEvent
import com.jacks_lan.thetodolistapp.presentation.feature.task_detail.view_model.TaskDetailViewModel
import com.jacks_lan.thetodolistapp.utils.DummyData.dummyTasks

@Composable
fun TaskDetailScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    viewModel: TaskDetailViewModel = hiltViewModel()
) {

    MainScaffold(
        showBackArrow = true,
        title = "Task Details",
        onBackArrowClick = onBackClick
    ) { paddingValues ->

        val uiState = viewModel.uiState

        LaunchedEffect(key1 = true) {
            viewModel.effect.collect {
                when (it) {
                    TaskDetailEffect.NavigateBack -> onBackClick()

                    is TaskDetailEffect.ShowError -> {}
                }
            }
        }

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            if (uiState.task != null) {
                Text(uiState.task.title, style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text(uiState.task.description, style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Text(uiState.task.dueDate, style = MaterialTheme.typography.bodyLarge)
            } else {
                Text("Item not found", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }

}