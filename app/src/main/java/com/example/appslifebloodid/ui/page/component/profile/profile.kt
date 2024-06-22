package com.example.appslifebloodid.ui.page.component.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appslifebloodid.R
import com.example.appslifebloodid.ui.base.AuthViewModel
import com.example.appslifebloodid.ui.theme.poppinsFontFamily

@Composable
fun ProfileScreen(
    navController: NavController,
    authViewModel: AuthViewModel
) {
    val username = authViewModel.getUsername()


    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(vertical = 45.dp)
                .fillMaxWidth()
                .height(250.dp)
                .background(Color(0xffb20909)),
        ) {
            Column(
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
            ) {
                Row{
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        contentDescription = "Icon Back",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .size(width = 50.dp, height = 50.dp)
                            .clickable {
                                navController.popBackStack()
                            }
                    )
                    Box(
                        modifier = Modifier.padding(vertical = 8.dp, ),
                    ) {
                        Text(
                            text = "PROFILE",
                            style = TextStyle(
                                fontSize = 25.sp,
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            ),
                        )
                    }
                }
                Row(
                    modifier = Modifier.padding(vertical = 20.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = 180.dp, height = 150.dp)
                    ) {
                        Column {
                            Text(
                                text = "Halo, ${username ?: "Tidak ada nama"}",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontFamily = poppinsFontFamily,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.White
                                ), modifier = Modifier.padding(vertical = 5.dp, horizontal = 30.dp)
                            )
                            Text(
                                text = "Apakah anda ingin donor darah ?",
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    fontFamily = poppinsFontFamily,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.White
                                ), modifier = Modifier.padding(vertical = 5.dp, horizontal = 30.dp)
                            )
                        }
                    }
                    Image(
                        painter = painterResource(id = R.drawable.img_profile),
                        contentDescription = "icon_profile",
                        modifier = Modifier.size(width = 190.dp, height = 120.dp)
                    )


                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .size(190.dp, height = 120.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(Color(0xffb20909)),

                contentAlignment = Alignment.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.img_people),
                        contentDescription = "icon people",
                        modifier = Modifier.size(width = 70.dp, height = 60.dp)
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Darah Anda",
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            )
                        )
                        Text(
                            text = "A+", style = TextStyle(
                                fontSize = 15.sp,
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            )
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .size(190.dp, height = 120.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(Color(0xffb20909)),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = 50.dp, height = 50.dp)
                            .background(Color.White)
                    ) {

                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Riwayat Donor",
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            )
                        )

                        Text(
                            text = "0", style = TextStyle(
                                fontSize = 15.sp,
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            )
                        )
                    }
                }
            }
        }
    }


    // Item Profile
//    LazyColumn {
//        item {
//            ItemProfile()
//        }
//    }
}