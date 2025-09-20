package com.jacks_lan.thetodolistapp.presentation.feature.task_list.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jacks_lan.thetodolistapp.domain.use_case.DeleteTaskUseCase
import com.jacks_lan.thetodolistapp.domain.use_case.GetAllTasksUseCase
import com.jacks_lan.thetodolistapp.presentation.feature.task_list.state.TaskListEffect
import com.jacks_lan.thetodolistapp.presentation.feature.task_list.state.TaskListEvent
import com.jacks_lan.thetodolistapp.presentation.feature.task_list.state.TaskListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskListViewModel @Inject constructor(
    private val getAllTasksUseCase: GetAllTasksUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
) : ViewModel() {


    var uiState by mutableStateOf(TaskListUiState())
        private set

    //Effect
    private val _effect = MutableSharedFlow<TaskListEffect>()
    val effect = _effect.asSharedFlow()


    init {
        onEvent(TaskListEvent.LoadTasks)
    }

    fun getAllTasks() {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true)
            delay(1000)
            getAllTasksUseCase().collect { taskList ->
                uiState = uiState.copy(tasks = taskList, isLoading = false)
            }
        }
    }

    fun deleteTask(itemId: Int) {
        viewModelScope.launch {
            deleteTaskUseCase(itemId)
            onEvent(TaskListEvent.LoadTasks)
        }
    }

    fun onEvent(event: TaskListEvent) {
        when (event) {
            is TaskListEvent.LoadTasks -> getAllTasks()
            is TaskListEvent.OnDeleteTaskClick -> deleteTask(event.taskId)
            is TaskListEvent.OnTaskClick -> navigateToDetailScreen()
            is TaskListEvent.OnAddTaskClick -> navigateToCreateScreen()
        }
    }

    fun navigateToDetailScreen() {
        viewModelScope.launch {
            _effect.emit(TaskListEffect.NavigateToTaskDetail(1))
        }
    }

    fun navigateToCreateScreen() {
        viewModelScope.launch {
            _effect.emit(TaskListEffect.NavigateToAddTask)
        }
    }
}