package com.example.baitaptuan6.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.baitaptuan6.data.Task
import com.example.baitaptuan6.view.components.TaskItem
import com.example.baitaptuan6.viewmodel.TaskViewModel
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun TaskListScreen(navController: NavController, viewModel: TaskViewModel = viewModel()) {
    val tasks = viewModel.tasks.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "List",
                        color = Color(0xFF2196F3), // Màu xanh lam
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Quay lại",
                            tint = Color.White,
                            modifier = Modifier
                                .background(Color(0xFF2196F3), shape = CircleShape)
                                .padding(8.dp)
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { navController.navigate("add_task") }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Thêm mới",
                            tint = Color.White,
                            modifier = Modifier
                                .background(
                                    Color(0xFFF44336), // Nền đỏ
                                    shape = CircleShape
                                )
                                .padding(8.dp)
                                .border(2.dp, Color(0xFFFF9800), CircleShape) // Viền cam
                        )
                    }
                },
                backgroundColor = Color.White
            )
        },
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
                    selected = true,
                    onClick = {}
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Add, contentDescription = null) },
                    selected = false,
                    onClick = { navController.navigate("add_task") }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Settings, contentDescription = null) },
                    selected = false,
                    onClick = {}
                )
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(tasks) { task ->
                TaskItem(task)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskListScreen(){
    TaskListScreen(navController = rememberNavController())
}