package com.example.appslifebloodid.ui.page.component.menu_home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.appslifebloodid.data.network.RetrofitInstance
import com.example.appslifebloodid.data.repository.EventRepository
import com.example.appslifebloodid.ui.base.EventViewModel
import com.example.appslifebloodid.ui.base.EventViewModelFactory

@Composable
fun DetailEvent(
    navController: NavController,
    locationId: Int,
    viewModel: EventViewModel = viewModel(
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

            Column(modifier = Modifier) {
                Spacer(modifier = Modifier.height(20.dp))
                Image(
                    painter = rememberImagePainter(
                        data = imageUrl,
                        builder = {
                            crossfade(true)
                        }
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .width(400.dp)
                        .height(300.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = location.title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 20.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = location.address,
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 20.dp)
                )
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