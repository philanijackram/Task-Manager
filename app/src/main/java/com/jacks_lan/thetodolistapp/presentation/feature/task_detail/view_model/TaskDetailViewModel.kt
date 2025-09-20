package com.jacks_lan.thetodolistapp.presentation.feature.task_detail.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jacks_lan.thetodolistapp.domain.use_case.GetTaskByIdUseCase
import com.jacks_lan.thetodolistapp.presentation.feature.task_detail.state.TaskDetailEffect
import com.jacks_lan.thetodolistapp.presentation.feature.task_detail.state.TaskDetailEvent
import com.jacks_lan.thetodolistapp.presentation.feature.task_detail.state.TaskDetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskDetailViewModel @Inject constructor(
    val getTaskByIdUseCase: GetTaskByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var uiState by mutableStateOf(TaskDetailUiState())
        private set

    private val _effect = MutableSharedFlow<TaskDetailEffect>()
    val effect = _effect.asSharedFlow()

    init {
        val itemId = savedStateHandle.get<Int>("itemId") ?: -1
        onEvent(TaskDetailEvent.LoadTask(itemId))
    }

    fun onEvent(taskDetailEvent: TaskDetailEvent) {
        when (taskDetailEvent) {
            is TaskDetailEvent.LoadTask -> loadTask(taskDetailEvent.taskId)
            is TaskDetailEvent.OnBackArrowClick -> navigateBack()

        }
    }


    fun loadTask(taskId: Int) {
        uiState = uiState.copy(isLoading = true)
        viewModelScope.launch {
            delay(1000)
            val task = getTaskByIdUseCase(taskId)
            if (task == null) {
                uiState = uiState.copy(isLoading = false, error = "Task not found")
                return@launch
            }
            uiState = uiState.copy(task = task, isLoading = false)

        }
    }

    fun navigateBack() {
        viewModelScope.launch {
            _effect.emit(TaskDetailEffect.NavigateBack)
        }

    }
}