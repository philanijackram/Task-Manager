package com.jacks_lan.thetodolistapp.presentation.feature.task_creation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CreateTaskScreen(modifier: Modifier = Modifier) {
    Box(
        modifier=modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Upon This Rock I shall build my church",
            modifier = modifier
        )
    }

}