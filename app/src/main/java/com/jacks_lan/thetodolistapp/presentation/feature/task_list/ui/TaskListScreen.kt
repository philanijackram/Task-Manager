package com.jacks_lan.thetodolistapp.presentation.feature.task_list.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jacks_lan.thetodolistapp.domain.model.TaskItem
import com.jacks_lan.thetodolistapp.nav.Screen
import com.jacks_lan.thetodolistapp.utils.DummyData.dummyTasks

@Composable
fun TaskListScreen(modifier: Modifier = Modifier, navController: NavController) {

    val tasks = remember { mutableStateListOf<TaskItem>().apply { addAll(dummyTasks) } }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Item List", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        tasks.forEach { item ->
            TaskItem(
                item = item,
                onCardClick = {
                    navController.navigate(Screen.TaskDetailScreen.route + "/${item.id}")
                },
                onDeleteClick = {
                    tasks.remove(item)
                }
            )
        }
    }
}

@Preview
@Composable
fun TaskItem(
    item: TaskItem=dummyTasks[0],
    onCardClick: () -> Unit={},
    onDeleteClick: () -> Unit={}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable {
                onCardClick()
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
                onClick = { onDeleteClick() },
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