package com.example.appslifebloodid.ui.page.component.menu_home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.appslifebloodid.R
import com.example.appslifebloodid.data.network.RetrofitInstance
import com.example.appslifebloodid.data.repository.EventRepository
import com.example.appslifebloodid.ui.base.EventViewModel
import com.example.appslifebloodid.ui.base.EventViewModelFactory

@Composable
fun DetailEvent(
    navController: NavController, locationId: Int, viewModel: EventViewModel = viewModel(
        factory = EventViewModelFactory(EventRepository(RetrofitInstance.api))
    )
) {
    val locationDetail by viewModel.locationDetail.collectAsState()

    // Fetch location detail when the composable is first launched
    LaunchedEffect(locationId) {
        viewModel.getLocationDetail(locationId)
    }

    locationDetail?.let { location ->
        val imageUrl = RetrofitInstance.baseUrl + location.image_url

        Column {
            Column(modifier = Modifier
            ) {
                ConstraintLayout(modifier = Modifier,
                    ){
                    val (topImg, profile, item) = createRefs()
                    Image(painter = rememberImagePainter(data = imageUrl, builder = {
                        crossfade(true)
                    }),
                        contentDescription = null,
                        modifier = Modifier
                            .width(400.dp)
                            .height(300.dp))
                    Column(
                        modifier = Modifier
                            .padding(top = 50.dp, start = 20.dp)

                    ){
                        Box(
                            modifier = Modifier
                                .size(35.dp)
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
                    }


                }

                Text(
                    text = location.title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 20.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row (modifier = Modifier.padding(start = 20.dp)){
                    Row {
                        Image(painter = painterResource(id = R.drawable.jam), contentDescription = "lokasi", modifier = Modifier.size(20.dp))
                        Text(
                            text = "22 Maret 2024",
                            fontSize = 16.sp,
                            modifier = Modifier.padding(start = 5.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(100.dp))
                    Row {
                        Image(painter = painterResource(id = R.drawable.lokasi), contentDescription = "lokasi", modifier = Modifier.size(20.dp))
                        Text(
                            text = location.address,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(start = 5.dp)
                        ) 
                    } 
                }
                
                Spacer(modifier = Modifier.height(10.dp))
                Box(modifier = Modifier.padding(start = 20.dp)) {
                    Button(
                        onClick = { navController.navigate("PendaftaranEvent") },
                        modifier = Modifier
                            .width(150.dp)
                            .height(40.dp),

                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xffE35A5A))
                    ) {
                        Text(text = "Pendaftaran", fontSize = 20.sp)
                    }
                }
            }
        }
    }
}