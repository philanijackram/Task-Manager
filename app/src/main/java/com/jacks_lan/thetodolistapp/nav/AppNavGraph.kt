package com.jacks_lan.thetodolistapp.nav

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.jacks_lan.thetodolistapp.presentation.components.MainScaffold
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
            TaskListScreen(
                onCardClick = { taskId ->
                    navController.navigate(Screen.TaskDetailScreen.passId(taskId))
                },
                onFabClick = {
                    navController.navigate(Screen.CreateTaskScreen.route)
                }
            )
        }

        composable(
            route = Screen.TaskDetailScreen.route,
            arguments = listOf(
                navArgument("itemId") { type = NavType.IntType }
            ) ) { backStackEntry ->

            TaskDetailScreen(
                modifier = Modifier,
                onBackClick = { navController.popBackStack()},
            )
        }

        composable(route = Screen.CreateTaskScreen.route) {
            MainScaffold(
                showBackArrow = true,
                title = "Create Task",
                onBackArrowClick = { navController.popBackStack() }
            ) { paddingValues ->
                CreateTaskScreen(
                    modifier = Modifier.padding(paddingValues),
                    onNavigateBack = { navController.popBackStack() }
                )
            }
        }
    }
}