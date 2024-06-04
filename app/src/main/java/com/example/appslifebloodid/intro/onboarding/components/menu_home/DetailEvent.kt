package com.example.appslifebloodid.intro.onboarding.components.menu_home

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appslifebloodid.data.DataGrid

@Composable
fun DetailEvent(modifier: Modifier = Modifier,
                navController: NavController,
                eventId: Int?) {
    val event = DataGrid.GridEvent.find { it.id == eventId }

    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(top = 35.dp)
                .background(Color(0xffE35A5A))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.padding(top = 10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        tint = Color.White,
                        modifier = Modifier.size(width = 30.dp, height = 30.dp),
                        contentDescription = "Icon Arrow"
                    )
                }
                Spacer(modifier = Modifier.width(100.dp))
                Text(
                    text = "Detail Event",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 10.dp),
                    color = Color.White
                )
            }
        }
        event?.let {
            Column(modifier = Modifier) {
                Spacer(modifier = Modifier.height(20.dp))
                Image(
                    painter = painterResource(id = it.photo),
                    contentDescription = null,
                    modifier = Modifier
                        .width(400.dp)
                        .height(300.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = it.title, fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 20.dp))
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = it.alamat, fontSize = 16.sp, color = Color.Gray, modifier = Modifier.padding(start = 20.dp))
                Spacer(modifier = Modifier.height(10.dp))
                Box (modifier = Modifier.padding(start = 20.dp)){
                    Button(onClick = { /*TODO*/ }, modifier = Modifier
                        .width(150.dp)
                        .height(40.dp), shape = RoundedCornerShape(10.dp), colors = ButtonDefaults.buttonColors(Color(0xffE35A5A))) {
                        Text(text = "Pendaftaran", fontSize = 20.sp)
                    }
                }

            }
        }
    }
}