package com.jacks_lan.thetodolistapp.presentation.feature.task_creation.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jacks_lan.thetodolistapp.domain.model.TaskItem
import com.jacks_lan.thetodolistapp.domain.use_case.CreateTaskUseCase
import com.jacks_lan.thetodolistapp.presentation.feature.task_creation.state.CreateTaskEffect
import com.jacks_lan.thetodolistapp.presentation.feature.task_creation.state.CreateTaskEvent
import com.jacks_lan.thetodolistapp.presentation.feature.task_creation.state.CreateTaskUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateTaskViewModel @Inject constructor(
    val createTaskUseCase: CreateTaskUseCase
) : ViewModel() {

    var uiState by mutableStateOf(CreateTaskUiState())
        private set

    private val _effect = MutableSharedFlow<CreateTaskEffect>()
    val effect = _effect.asSharedFlow()

    fun createTask(
        taskItem: TaskItem
    ) {
        uiState = uiState.copy(isLoading = true)
        viewModelScope.launch {
            createTaskUseCase(
                taskItem
            )
            uiState = uiState.copy(isLoading = false)
            navigateBack()
        }
    }

    fun onEvent(event: CreateTaskEvent) {
        when (event) {
            is CreateTaskEvent.OnCreateTask -> {
                createTask(event.taskItem)
            }

            is CreateTaskEvent.OnBackClicked -> navigateBack()
            is CreateTaskEvent.OnDateChange -> {
                uiState = uiState.copy(date = event.date)
            }
            is CreateTaskEvent.OnDescriptionChange -> {
                uiState = uiState.copy(description = event.description)
            }
            is CreateTaskEvent.OnTitleChange -> {
                uiState = uiState.copy(title = event.title)
            }
        }
    }

    fun navigateBack() {
        viewModelScope.launch {
            _effect.emit(CreateTaskEffect.NavigateBack)
        }
    }

}