package com.example.baitap1api

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.baitap1api.navigation.Screen
import com.example.baitap1api.ui.screens.DetailScreen
import com.example.baitap1api.ui.screens.ListScreen
import com.example.baitap1api.ui.screens.RootScreen
import com.example.baitap1api.ui.theme.Baitap1apiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Baitap1apiTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screen.Root.route) {
                    composable(Screen.Root.route) {
                        RootScreen(
                            onNavigateToList = { navController.navigate(Screen.List.route) }
                        )
                    }
                    composable(Screen.List.route) {
                        ListScreen(
                            onNavigateToDetail = { taskId ->
                                navController.navigate(Screen.Detail.createRoute(taskId))
                            },
                            onNavigateBack = { navController.popBackStack() }
                        )
                    }
                    composable(
                        route = Screen.Detail.route,
                        arguments = listOf(
                            navArgument("taskId") { type = NavType.IntType }
                        )
                    ) { backStackEntry ->
                        val taskId = backStackEntry.arguments?.getInt("taskId") ?: 0
                        DetailScreen(
                            taskId = taskId,
                            onNavigateBackToRoot = { navController.popBackStack(Screen.Root.route, inclusive = false) },
                            onNavigateBack = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}