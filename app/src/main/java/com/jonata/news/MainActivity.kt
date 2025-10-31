package com.jonata.news

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import com.jonata.core.navigation.NewsNavGraphRoute
import com.jonata.datasource.api.manager.TokenManager
import com.jonata.news.navigation.NavHostApp
import com.jonata.news.ui.theme.NewsTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var tokenManager: TokenManager

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val isLoggedIn by tokenManager.isLoggedIn.collectAsState()

            val startDestination = if (isLoggedIn) {
                NewsNavGraphRoute.NewsHomeScreen
            } else {
                NewsNavGraphRoute.Root
            }


            NewsTheme {

                val navHostController = rememberNavController()

                NavHostApp(
                    navHostController = navHostController,
                    startDestination = startDestination
                )
            }
        }
    }
}

