package com.jonata.news.ui.splash

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.jonata.core.presentetion.navigation.NavigateManager

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel<SplashViewModel>(),
    navigateManager: NavigateManager) {

    navigateManager.PopUpTo(viewModel.initScreen)

}