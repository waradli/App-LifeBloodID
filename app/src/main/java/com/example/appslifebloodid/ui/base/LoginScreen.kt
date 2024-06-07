package com.example.appslifebloodid.ui.base

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(authViewModel: AuthViewModel) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    val loginResult by authViewModel.loginResult.observeAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = username.value,
            onValueChange = { username.value = it },
            label = { Text("Email") }
        )
        TextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )
        Button(
            onClick = { authViewModel.login(username.value, password.value) },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Login")
        }

        loginResult?.let {
            Text(text = "Login Success! Token: ${it.token}")
        }
    }
}