package com.example.roomdatabase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.roomdatabase.ui.navigation.Navigation
import com.example.roomdatabase.ui.theme.RoomDatabaseTheme

class DefaApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomDatabaseTheme {
                val navController = rememberNavController()
                Navigation(navController)
            }
        }
    }
}