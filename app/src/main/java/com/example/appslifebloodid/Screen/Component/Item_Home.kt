package com.app_donor_darah.Screen.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appslifebloodid.R

@Composable
fun Item_Home(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color(0xffE35A5A), shape = RectangleShape)

    ) {
        Column(


        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()

            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_profile),
                    contentDescription = "Image Profile",
                    modifier = Modifier
                        .size(75.dp)
                        .padding(start = 10.dp, top = 20.dp)
                )
                Column(
                    modifier = Modifier.padding(
                        top = 20.dp,
                    ),

                    ) {
                    Text(
                        text = "Hallo Ali Wardana",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Color.White,
                        )
                    )
                    Text(
                        text = "122233",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Color.White,

                            )
                    )
                }
                Icon(
                    painter = painterResource(id = R.drawable.notification),
                    contentDescription = "Notification",
                    modifier = Modifier
                        .size(55.dp)
                        .padding(start = 30.dp, top = 20.dp)

                )
            }
        }
    }
}