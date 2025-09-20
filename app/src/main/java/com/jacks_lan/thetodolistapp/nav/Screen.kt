package com.jacks_lan.thetodolistapp.nav

sealed class Screen(val route: String) {
    object TaskListScreen : Screen("task_list_screen")
    object TaskDetailScreen : Screen("task_detail_screen/{itemId}"){
        fun passId(itemId: Int) = "task_detail_screen/$itemId"
    }
    object CreateTaskScreen : Screen("create_task_screen")
}