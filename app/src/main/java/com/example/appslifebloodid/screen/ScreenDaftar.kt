package com.example.appslifebloodid.screen

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appslifebloodid.R

@Composable
fun ScreenDaftar(navController: NavController) {
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF1F1F1))
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var nama by remember {
                mutableStateOf("")
            }
            var email by remember{
                mutableStateOf("")
            }
            var password by remember{
                mutableStateOf("")
            }

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
                OutlinedTextField(value = nama, onValueChange = {nama = it}, label = { Text(text = "Nama Lengkap")}, modifier = Modifier.width(330.dp))
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(value = email, onValueChange = {email = it}, label = { Text(text = "Email atau No.Hp")}, modifier = Modifier.width(330.dp))
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(value = password, onValueChange = {password=it}, label = { Text(text = "Password")}, modifier = Modifier.width(330.dp))
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 20.dp)
            ){
                var Checked by remember{
                    mutableStateOf(false)
                }
                Checkbox(checked = Checked, onCheckedChange = {Checked = it})
                Text(text = "Dengan mendaftar, kamu telah menyetujui Ketentuan Pemakaian dan Pengaturan Privasi yang ada di LifeBloodID ", fontSize = 13.sp)
            }
            Spacer(modifier = Modifier.height(15.dp))
            Button(onClick = { navController.navigate("masuk") },
                modifier = Modifier
                    .width(330.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFB20909)
                )
                ) {
                Text(text = "Daftar", fontSize = 18.sp)
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



