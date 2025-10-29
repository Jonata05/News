package com.jonata.news

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.jonata.core.navigation.NewsNavGraphRoute
import com.jonata.news.navigation.NavHostApp
import com.jonata.news.ui.theme.NewsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            NewsTheme {

                val navHostController = rememberNavController()

                NavHostApp(
                    navHostController = navHostController,
                    startDestination = NewsNavGraphRoute.Root
                )
            }
        }
    }
}

