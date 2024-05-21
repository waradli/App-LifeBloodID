package com.example.appslifebloodid.Page.Component.Item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 40.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(Color(0xffE35A5A))
                ) {
                    Column(
                        modifier = Modifier.padding(top = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth()


                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.img_profile),
                                contentDescription = "Image Profile",
                                modifier = Modifier
                                    .size(75.dp)
                                    .padding(start = 30.dp, top = 20.dp)
                            )
                            Column(
                                modifier = Modifier.padding(
                                    top = 30.dp, start = 20.dp
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
                            Box(
                                modifier = Modifier.padding(start = 115.dp)

                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.notification),
                                    contentDescription = "Notification",
                                    modifier = Modifier
                                        .size(55.dp)
                                        .padding(start = 20.dp, top = 30.dp)

                                )
                            }

                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        OutlinedTextField(
                            value = "",
                            onValueChange = { /* Change listener for search query */ },
                            leadingIcon = {
                                Icon(Icons.Filled.Search, contentDescription = "Search Icon")
                            },
                            modifier = Modifier
                                .width(330.dp)
                                .height(50.dp),
                            shape = RoundedCornerShape(20.dp),
                            colors = TextFieldDefaults.colors()

                        )
                    }
                }
    }
}