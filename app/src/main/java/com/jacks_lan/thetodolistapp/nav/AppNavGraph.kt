package com.jacks_lan.thetodolistapp.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jacks_lan.thetodolistapp.presentation.feature.task_creation.ui.CreateTaskScreen
import com.jacks_lan.thetodolistapp.presentation.feature.task_detail.ui.TaskDetailScreen
import com.jacks_lan.thetodolistapp.presentation.feature.task_list.ui.TaskListScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.TaskListScreen.route
    ) {
        composable(route = Screen.TaskListScreen.route) {
            TaskListScreen(navController = navController)
        }

        composable(route = Screen.TaskDetailScreen.route) {
            TaskDetailScreen(backStackEntry = it)
        }

        composable(route = Screen.CreateTaskScreen.route) {
            CreateTaskScreen()
        }


    }
}