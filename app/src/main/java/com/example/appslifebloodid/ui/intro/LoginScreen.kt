package com.example.appslifebloodid.ui.intro

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appslifebloodid.R
import com.example.appslifebloodid.ui.base.AuthViewModel

@Composable
fun LoginScreen(authViewModel: AuthViewModel, navController: NavController) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    val loginResult by authViewModel.loginResult.observeAsState()

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF1F1F1))
    ){
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 60.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.White, shape = CircleShape)
                        .shadow(2.dp, CircleShape)
                        .clickable { navController.popBackStack() },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = "Back"
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Masuk",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 110.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Image(painter = painterResource(id = R.drawable.imgmsk), contentDescription ="gambar masuk", modifier = Modifier
                .width(250.dp)
                .height(250.dp) )
            Text(text = "Login akun agar anda dapat menemukan \n" +
                    "        informasi terkait donor darah", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Column (
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ){
                OutlinedTextField(
                    value = username.value,
                    onValueChange = { username.value = it },
                    label = { Text(text = "Email atau No.Hp")},
                    modifier = Modifier
                        .width(365.dp)
                        .height(60.dp),
                    shape = RoundedCornerShape(10.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = password.value,
                    onValueChange = { password.value = it },
                    label = { Text(text = "Password")},
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .width(365.dp)
                        .height(60.dp),
                    shape = RoundedCornerShape(10.dp)
                )
            }
            Spacer(modifier = Modifier.height(3.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 260.dp, end = 0.dp)
            ) {
                Text(text = "Lupa Kata Sandi?",
                    modifier = Modifier.clickable {  },
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light)
            }
            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = { authViewModel.login(username.value, password.value) },
                modifier = Modifier
                    .width(365.dp)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFB20909)
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Masuk", fontSize = 18.sp)
            }

            loginResult?.let { result ->
                if (result.message == "Login successful") {
                    Toast.makeText(LocalContext.current, "Login successful", Toast.LENGTH_SHORT).show()
                    navController.navigate("home") {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(15.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier
                    .width(100.dp)
                    .height(1.dp)
                    .background(Color.Gray))
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Atau masuk dengan", fontSize = 14.sp)
                Spacer(modifier = Modifier.width(10.dp))
                Box(modifier = Modifier
                    .width(100.dp)
                    .height(1.dp)
                    .background(Color.Gray))
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(painter = painterResource(id = R.drawable.google),
                    contentDescription = "Google",
                    modifier = Modifier
                        .size(60.dp)
                        .clickable { /* google */ })

                Image(painter = painterResource(id = R.drawable.facebook),
                    contentDescription = "Facebook",
                    modifier = Modifier
                        .size(60.dp)
                        .clickable { /* facebook */ })
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier.padding(top = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Belum punya akun?",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light
                )
                Text(
                    text = "Daftar",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable {

                    }
                )
            }
        }
    }

}