package com.example.bai2tuan5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp()
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()
    val context = LocalContext.current

    // State to hold user info
    var userName by remember { mutableStateOf("") }
    var userEmail by remember { mutableStateOf("") }
    var userDateOfBirth by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    // Web Client ID for Google Sign-In
    val webClientId = "754814570339-6v2kc3us5qfncmb3fraplt3c2c4u34g0.apps.googleusercontent.com"

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                context = context,
                onSignInSuccess = { name, email, dateOfBirth ->
                    userName = name
                    userEmail = email
                    userDateOfBirth = dateOfBirth
                    navController.navigate("profile")
                },
                onSignInFailure = { message ->
                    errorMessage = message
                }
            )
            // Display error message if exists
            if (errorMessage.isNotEmpty()) {
                Text(text = errorMessage)
            }
        }
        composable("profile") {
            UserProfileScreen(
                name = userName,
                email = userEmail,
                dateOfBirth = userDateOfBirth
            )
            // Add logout functionality
            val googleSignInClient = getGoogleSignInClient(context, webClientId)
            Button(onClick = {
                googleSignInClient.signOut().addOnCompleteListener {
                    navController.navigate("login") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            }) {
                Text(text = "Logout")
            }
        }
    }
}

private fun getGoogleSignInClient(context: android.content.Context, webClientId: String): GoogleSignInClient {
    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(webClientId)
        .requestEmail()
        .requestProfile()
        .build()
    return GoogleSignIn.getClient(context, gso)
}