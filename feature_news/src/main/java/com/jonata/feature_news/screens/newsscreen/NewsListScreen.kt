package com.jonata.feature_news.screens.newsscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel



@Composable
fun NewsListScreen(
    viewModel: NewsListViewModel = hiltViewModel()
){

    val token by viewModel.token.collectAsState()


    Column {

        Spacer(Modifier.height(100.dp))

        Text(token.toString())

        Button({viewModel.login()}) {
            Text("Clique")
        }
    }




}