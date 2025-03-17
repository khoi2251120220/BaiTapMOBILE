package com.example.bai2tuan3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "splash_screen") {
            composable("splash_screen") { SplashScreen(navController) }
            composable("get_started_first") { GetStartedFirstScreen(navController) }
            composable("get_started_second") { GetStartedSecondScreen(navController) }
            composable("get_started_third") { GetStartedThirdScreen(navController) }
        }
    }
}

@Composable
fun SplashScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Replace the Box placeholder with an Image
        Image(
            painter = painterResource(id = R.drawable.img), // Replace with your logo image resource
            contentDescription = "UTH Logo",
            modifier = Modifier.size(150.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "UTH SmartTasks",
            fontSize = 24.sp,
            color = Color.Blue,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "UNIVERSITY OF TRANSPORT AND COMMUNICATIONS CITY",
            fontSize = 14.sp,
            color = Color.Red,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { navController.navigate("get_started_first") },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Next", fontSize = 18.sp)
        }
    }
}

@Composable
fun GetStartedFirstScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Replace the Box placeholder with an Image
        Image(
            painter = painterResource(id = R.drawable.img_1),
            contentDescription = "Easy Time Management Illustration",
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Easy Time Management",
            fontSize = 20.sp,
            color = Color.Blue,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "With management based on priority and daily tasks, it will give you convenience in managing and determining the tasks that must be done first.",
            fontSize = 14.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("skip", color = Color.Blue, fontSize = 14.sp)
            Button(
                onClick = { navController.navigate("get_started_second") },
                modifier = Modifier.height(50.dp)
            ) {
                Text("Next", fontSize = 18.sp)
            }
        }
    }
}

@Composable
fun GetStartedSecondScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Replace the Box placeholder with an Image
        Image(
            painter = painterResource(id = R.drawable.img_2),
            contentDescription = "Increase Work Effectiveness Illustration",
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Increase Work Effectiveness",
            fontSize = 20.sp,
            color = Color.Blue,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Time management and the determination of more important tasks will give your statistics better and always improve.",
            fontSize = 14.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("skip", color = Color.Blue, fontSize = 14.sp)
            Button(
                onClick = { navController.navigate("get_started_third") },
                modifier = Modifier.height(50.dp)
            ) {
                Text("Next", fontSize = 18.sp)
            }
        }
    }
}

@Composable
fun GetStartedThirdScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Replace the Box placeholder with an Image
        Image(
            painter = painterResource(id = R.drawable.img_3),
            contentDescription = "Reminder Notification Illustration",
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Reminder Notification",
            fontSize = 20.sp,
            color = Color.Blue,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "The advantage of this application is that it also provides reminders for you so you don't forget to keep doing your assignments well and according to the time you have set.",
            fontSize = 14.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { /* Chuyển đến màn hình chính hoặc kết thúc onboarding */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Get Started", fontSize = 18.sp)
        }
    }
}