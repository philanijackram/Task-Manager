package com.jacks_lan.thetodolistapp.presentation.feature.task_list.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jacks_lan.thetodolistapp.nav.Screen
import com.jacks_lan.thetodolistapp.utils.DummyData.dummyTasks

@Composable
fun TaskListScreen(modifier: Modifier = Modifier, navController: NavController) {
    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text("Item List", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        dummyTasks.forEach { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .clickable {
                        navController.navigate(Screen.TaskDetailScreen.passId(item.id))
                    }
            ) {
                Text(
                    text = item.title,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}