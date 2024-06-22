package com.example.appslifebloodid.ui.page.component.menu_home.jadwal

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appslifebloodid.ui.page.component.menu_home.jadwal.data.dataJadwal
import com.example.appslifebloodid.ui.page.component.menu_home.jadwal.model.jadwal
import com.example.appslifebloodid.ui.theme.poppinsFontFamily
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScreenJadwalDonor(
    modifier: Modifier = Modifier,
    navController: NavController,
    jadwall: List<jadwal> = dataJadwal.listJadwal
) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

    // Field BottomSheet
    var namaAcara by remember {
        mutableStateOf("")
    }
    var keterangan by remember {
        mutableStateOf("")
    }
    var tanggal by remember {
        mutableStateOf("")
    }


    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .padding(vertical = 30.dp)
                .background(Color(0xffb20909))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp, horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(
                    onClick = { navController.popBackStack() },
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        tint = Color.White,
                        modifier = Modifier.size(30.dp, 30.dp),
                        contentDescription = "Icon Arrow"
                    )
                }
                Text(
                    text = "Jadwal Donor Darah",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 60.dp),
                    color = Color.White
                )
            }
        }
        Column {
            Calendar()
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
            ) {
                items(jadwall, key = { it.id }) {
                    ItemJadwal(jadwall = it)
                }
            }
        }
        FloatingActionButton(
            onClick = { showBottomSheet = true },
            modifier = Modifier
                .align(Alignment.End)
                .padding(16.dp),
            containerColor = Color(0xffb20909)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add",
                tint = Color.White
            )
        }
    }

    // BottomSheet
    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Buat Jadwal Baru",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = poppinsFontFamily,
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = namaAcara,
                    onValueChange = { namaAcara = it },
                    label = { Text("Nama Acara") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = keterangan,
                    onValueChange = { keterangan = it },
                    label = { Text("Keterangan") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = tanggal,
                    onValueChange = { tanggal = it },
                    label = { Text("Tanggal") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        // Handle the "Save" action here
                        showBottomSheet = false
                    },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Save")
                }
            }
        }
    }
}


