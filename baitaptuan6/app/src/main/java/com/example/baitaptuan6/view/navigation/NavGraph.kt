package com.example.baitaptuan6.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.baitaptuan6.view.screens.AddTaskScreen
import com.example.baitaptuan6.view.screens.TaskListScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "task_list") {
        composable("task_list") {
            TaskListScreen(navController)
        }
        composable("add_task") {
            AddTaskScreen(navController)
        }
    }
}