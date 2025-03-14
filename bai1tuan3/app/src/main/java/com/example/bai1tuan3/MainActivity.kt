package com.example.bai1tuan3
import androidx.compose.ui.text.style.TextDecoration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
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
        NavHost(navController = navController, startDestination = "welcome_screen") {
            composable("welcome_screen") { WelcomeScreen(navController) }
            composable("components_list_screen") { ComponentsListScreen(navController) }
            composable("text_detail_screen") { TextDetailScreen() }
            composable("image_detail_screen") { ImageDetailScreen() }
            composable("inputfield_detail_screen") { InputFieldDetailScreen() }
            composable("passwordfield_detail_screen") { PasswordFieldDetailScreen() }
            composable("column_detail_screen") { ColumnDetailScreen() }
            composable("row_detail_screen") { RowDetailScreen() }
        }
    }
}

@Composable
fun WelcomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.Settings, // Biểu tượng Jetpack Compose
            contentDescription = "Jetpack Compose Logo",
            modifier = Modifier.size(100.dp)
        )
        Text(
            text = "Jetpack Compose",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "Jetpack Compose is a modern toolkit for building native Android applications using a declarative programming approach.",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        Button(
            onClick = { navController.navigate("components_list_screen") },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = "I'm ready", fontSize = 18.sp)
        }
    }
}

@Composable
fun ComponentsListScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "UI Components List",
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        ComponentItem(
            title = "Text",
            description = "Displays text",
            onClick = { navController.navigate("text_detail_screen") }
        )
        ComponentItem(
            title = "Image",
            description = "Displays an image",
            onClick = { navController.navigate("image_detail_screen") }
        )
        ComponentItem(
            title = "TextField",
            description = "Input field for text",
            onClick = { navController.navigate("inputfield_detail_screen") }
        )
        ComponentItem(
            title = "PasswordField",
            description = "Input field for passwords",
            onClick = { navController.navigate("passwordfield_detail_screen") }
        )
        ComponentItem(
            title = "Column",
            description = "Arranges elements vertically",
            onClick = { navController.navigate("column_detail_screen") }
        )
        ComponentItem(
            title = "Row",
            description = "Arranges elements horizontally",
            onClick = { navController.navigate("row_detail_screen") }
        )
    }
}

@Composable
fun ComponentItem(title: String, description: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, fontSize = 18.sp, color = MaterialTheme.colorScheme.primary)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = description, fontSize = 14.sp, color = Color.Gray)
        }
    }
}

@Composable
fun TextDetailScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Text Detail", fontSize = 20.sp, modifier = Modifier.padding(bottom = 16.dp))
        Text(
            text = "The quick Brown fox jumps over the lazy dog.",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFF8D5524)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Text Styles Examples:",
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text("Bold Text", fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
        Text("Italic Text", fontStyle = androidx.compose.ui.text.font.FontStyle.Italic)
        Text("Underlined Text", textDecoration = TextDecoration.Underline) // Sửa ở đây
        Text("Colored Text", color = Color.Red)
    }
}

@Composable
fun ImageDetailScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Image Detail", fontSize = 20.sp, modifier = Modifier.padding(bottom = 16.dp))
        // Placeholder for images (since we can't load real images here)
        Box(modifier = Modifier.size(100.dp).background(Color.Gray), contentAlignment = Alignment.Center) {
            Text("Image 1", color = Color.White)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Image Styles Examples:", fontSize = 18.sp, modifier = Modifier.padding(bottom = 8.dp))
        Box(modifier = Modifier.size(80.dp).background(Color.LightGray), contentAlignment = Alignment.Center) {
            Text("Image 2", color = Color.Black)
        }
        // Add more image examples as needed (e.g., different sizes, shapes)
    }
}

@Composable
fun InputFieldDetailScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("TextField Detail", fontSize = 20.sp, modifier = Modifier.padding(bottom = 16.dp))
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Single Line") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("TextField Examples:", fontSize = 18.sp, modifier = Modifier.padding(bottom = 8.dp))
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Multi Line") },
            modifier = Modifier.fillMaxWidth(),
            maxLines = 3
        )
        // Add more TextField examples as needed
    }
}

@Composable
fun PasswordFieldDetailScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("PasswordField Detail", fontSize = 20.sp, modifier = Modifier.padding(bottom = 16.dp))
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Password") },
            visualTransformation = androidx.compose.ui.text.input.PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("PasswordField Examples:", fontSize = 18.sp, modifier = Modifier.padding(bottom = 8.dp))
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Password with Toggle") },
            visualTransformation = androidx.compose.ui.text.input.PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        // Add more PasswordField examples as needed
    }
}

@Composable
fun ColumnDetailScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Column Detail", fontSize = 20.sp, modifier = Modifier.padding(bottom = 16.dp))
        Column {
            Text("Item 1")
            Text("Item 2")
            Text("Item 3")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Column Examples:", fontSize = 18.sp, modifier = Modifier.padding(bottom = 8.dp))
        Column(horizontalAlignment = Alignment.End) {
            Text("Right Aligned 1")
            Text("Right Aligned 2")
        }
    }
}

@Composable
fun RowDetailScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Row Detail", fontSize = 20.sp, modifier = Modifier.padding(bottom = 16.dp))
        Row {
            Text("Item 1")
            Text("Item 2")
            Text("Item 3")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Row Examples:", fontSize = 18.sp, modifier = Modifier.padding(bottom = 8.dp))
        Row(verticalAlignment = Alignment.Bottom) {
            Text("Bottom 1")
            Text("Bottom 2")
        }
    }
}