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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun RegisterScreen(authViewModel: AuthViewModel, navController: NavController) {
    val username = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    val registerResult by authViewModel.registerResult.observeAsState()

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF1F1F1))
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
                    text = "Daftar",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 110.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.imgdft),
                contentDescription = "daftar",
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
            )
            Text(text = "Register akun agar anda dapat menemukan \n" +
                    "             informasi terkait donor darah", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(15.dp))
            Column (
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ){
                OutlinedTextField(
                    value = username.value,
                    onValueChange = { username.value = it },
                    label = { Text(text = "Nama Lengkap")},
                    modifier = Modifier
                        .width(365.dp)
                        .height(60.dp),
                    shape = RoundedCornerShape(10.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = email.value,
                    onValueChange = {email.value = it},
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
            Spacer(modifier = Modifier.height(15.dp))
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 8.dp, end = 15.dp)
            ){
                var Checked by remember{
                    mutableStateOf(false)
                }
                Checkbox(checked = Checked, onCheckedChange = {Checked = it})
                Text(text = "Dengan mendaftar, kamu telah menyetujui Ketentuan Pemakaian dan Pengaturan Privasi yang ada di LifeBloodID ", fontSize = 11.sp)
            }
            Spacer(modifier = Modifier.height(15.dp))
            Button(
                onClick = { authViewModel.register(username.value, email.value, password.value) },
                modifier = Modifier
                    .width(365.dp)
                    .height(48.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFB20909)
                )
                ) {
                Text(text = "Daftar", fontSize = 18.sp)
            }
            registerResult?.let { result ->
                if (result.message == "User registered successfully") {
                    Toast.makeText(LocalContext.current, "Daftar successfully", Toast.LENGTH_SHORT).show()
                    navController.navigate("login") {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "atau daftar dengan")
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
                    text = "Sudah punya akun?",
                    fontWeight = FontWeight.Light
                )
                Text(
                    text = "Masuk",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable {

                    }
                )
            }
        }
    }
}



