package com.jonata.feature_auth.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.jonata.core.components.NavigateManager
import com.jonata.core.components.SnackBarManager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateManager: NavigateManager,
    viewModel: HomeViewModel = hiltViewModel()
) {


    val idToken by viewModel.idToken.collectAsState()
    val expiresAt by viewModel.expiresAt.collectAsState()
    val refreshToken by viewModel.refreshToken.collectAsState()
    val displayName by viewModel.displayName.collectAsState()
    val email by viewModel.email.collectAsState()
    val registered by viewModel.registered.collectAsState()
    val localId by viewModel.localId.collectAsState()

    val scroll = rememberScrollState()


    navigateManager.PopUpTo(viewModel.navigate)
    SnackBarManager.ListenMessages()


    Scaffold(
        snackbarHost = { SnackBarManager.snackBarHost},
        topBar = {
            TopAppBar(title = { Text("Token Info") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(scroll),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.Start
        ) {
            TokenInfoItem(label = "ID Token", value = idToken)
            TokenInfoItem(label = "Expires At", value = expiresAt.toString())
            TokenInfoItem(label = "Refresh Token", value = refreshToken)
            TokenInfoItem(label = "Display Name", value = displayName)
            TokenInfoItem(label = "Email", value = email)
            TokenInfoItem(label = "Registered", value = registered.toString())
            TokenInfoItem(label = "Local ID", value = localId)
            Button({ viewModel.logout() },
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .align(Alignment.CenterHorizontally)) {
                Text("Sair")
            }
            Button({ viewModel.feedback() },
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .align(Alignment.CenterHorizontally)) {
                Text("toast")
            }
        }
    }
}


@Composable
private fun TokenInfoItem(label: String, value: String) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = label, style = MaterialTheme.typography.labelLarge)
        Text(
            text = value.ifBlank { "—" },
            style = MaterialTheme.typography.bodyLarge
        )
        Divider(modifier = Modifier.padding(vertical = 4.dp))
    }
}