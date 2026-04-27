package com.example.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController) {

    val note = selectedNote

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Note Details") },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Text("<")
                    }
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            Text(text = note?.title ?: "No Title")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = note?.description ?: "No Description")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetailScreen() {
    MyApplicationTheme {
        val navController = rememberNavController()

        // ✅ Fake data for preview
        selectedNote = Note("Sample Title", "Sample Description")

        DetailScreen(navController)
    }
}