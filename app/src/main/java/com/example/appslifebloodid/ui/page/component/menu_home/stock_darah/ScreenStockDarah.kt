package com.example.appslifebloodid.ui.page.component.menu_home.stock_darah

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appslifebloodid.ui.theme.poppinsFontFamily

@Composable
fun ScreenStockDarah(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(
        modifier = Modifier.padding(vertical = 30.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(Color(0xffb20909)),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 15.dp, horizontal = 20.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "Icon Arrow",
                    modifier = Modifier
                        .size(width = 30.dp, height = 30.dp)
                        .clickable {
                            navController.popBackStack()
                        },
                    tint = Color.White
                )
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Stock Darah",
                        style = TextStyle(
                            fontSize = 22.sp,
                            color = Color.White,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.SemiBold
                        ),
                        modifier = Modifier.padding(vertical = 5.dp, horizontal = 60.dp)
                    )
                }
            }
        }
        Column(
            modifier = Modifier.padding(vertical = 30.dp, horizontal = 20.dp)
        ) {
            Text(
                text = "Lokasi Stock Darah",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = poppinsFontFamily
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                OutlinedTextField(
                    value = "",
                    onValueChange = { /* Change listener for search query */ },
                    placeholder = {
                        Text(
                            text = "Cari Lokasi",
                            style = TextStyle(
                                fontFamily = poppinsFontFamily,
                                fontSize = 15.sp
                            )
                        )
                    },
                    modifier = Modifier
                        .width(260.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.colors()
                )
                Spacer(modifier = Modifier.width(10.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .width(80.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xffb20909))
                ) {
                    Text(
                        text = "Cari",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        fontFamily = poppinsFontFamily
                    )
                }
            }

        }
    }
}