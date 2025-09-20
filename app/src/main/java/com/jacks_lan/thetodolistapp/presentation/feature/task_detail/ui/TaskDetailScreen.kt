package com.jacks_lan.thetodolistapp.presentation.feature.task_detail.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import com.jacks_lan.thetodolistapp.utils.DummyData.dummyTasks

@Composable
fun TaskDetailScreen(modifier: Modifier = Modifier,backStackEntry: NavBackStackEntry) {
    val itemId = backStackEntry.arguments?.getString("itemId")?.toIntOrNull()
    val item = dummyTasks.find { it.id == itemId }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        if (item != null) {
            Text(item.title, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(item.description, style = MaterialTheme.typography.bodyLarge)
        } else {
            Text("Item not found", style = MaterialTheme.typography.bodyLarge)
        }
    }

}