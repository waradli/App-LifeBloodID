package com.example.appslifebloodid.intro.onboarding.components.menu_event

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DaftarEvent(modifier: Modifier = Modifier,
                navController: NavController
) {
    Column {
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(top = 35.dp)
                .background(Color(0xffE35A5A))
        ){
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.padding(top = 10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        tint = Color.White,
                        modifier = Modifier.size(50.dp),
                        contentDescription = "Icon Arrow"
                    )
                }
                Spacer(modifier = Modifier.width(100.dp))
                Text(
                    text = "Pendaftaran",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 10.dp),
                    color = Color.White
                )
            }
        }
    }
}