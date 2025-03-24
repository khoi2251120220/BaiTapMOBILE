package com.example.baitap1api.navigation

sealed class Screen(val route: String) {
    object Root : Screen("root")
    object List : Screen("list")
    object Detail : Screen("detail/{taskId}") {
        fun createRoute(taskId: Int) = "detail/$taskId"
    }
}