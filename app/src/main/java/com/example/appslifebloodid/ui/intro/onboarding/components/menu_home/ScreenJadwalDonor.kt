package com.example.appslifebloodid.ui.intro.onboarding.components.menu_home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenJadwalDonor(modifier: Modifier = Modifier, navController: NavController) {
    Column(modifier = modifier) {
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
                        modifier = Modifier.size(50.dp),
                        contentDescription = "Icon Arrow"
                    )
                }
                Spacer(modifier = Modifier.width(60.dp))
                Text(
                    text = "Jadwal Donor Darah",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 10.dp),
                    color = Color.White
                )
            }
        }
        Text(text = "Waktu Yang Tepat Untuk Donor Darah", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 20.dp, top = 20.dp))
        Column(modifier = Modifier.padding(start = 40.dp, top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Box (modifier = Modifier
                .width(300.dp)
                .height(300.dp)
                .padding(start = 10.dp)
                .background(Color(0xfff1f1f1)),
            ){
                CalendarViewWithDonorSchedule(modifier = Modifier.padding(start = 5.dp, end = 5.dp))
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
            FloatingActionButton(
                onClick = {  },
                modifier = Modifier
                    .padding(top = 220.dp, end = 20.dp)
                    .align(Alignment.End),
                containerColor = Color(0xffE35A5A)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    tint = Color.White
                )
            }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarViewWithDonorSchedule(modifier: Modifier = Modifier) {
    val currentMonth = remember { mutableStateOf(YearMonth.now()) }
    val currentDate = remember { mutableStateOf(LocalDate.now()) }
    val daysOfWeek = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header
        Text(
            text = currentMonth.value.month.getDisplayName(TextStyle.FULL, Locale.getDefault()) + " " + currentMonth.value.year,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        // Days of Week
        Row(modifier = Modifier.fillMaxWidth()) {
            daysOfWeek.forEach { day ->
                Text(
                    text = day,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
            }
        }

        // Dates
        val daysInMonth = currentMonth.value.lengthOfMonth()
        val firstDayOfMonth = LocalDate.of(currentMonth.value.year, currentMonth.value.month, 1)
        val firstDayOfWeek = firstDayOfMonth.dayOfWeek.value % 7

        Column {
            var currentDay = 1
            while (currentDay <= daysInMonth) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    for (i in 0..6) {
                        if (currentDay == 1 && i < firstDayOfWeek) {
                            Spacer(modifier = Modifier.weight(1f))
                        } else if (currentDay > daysInMonth) {
                            Spacer(modifier = Modifier.weight(1f))
                        } else {
                            val date = LocalDate.of(currentMonth.value.year, currentMonth.value.month, currentDay)
                            val isDonorDay = isDonorDay(date)
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .weight(1f)
                                    .aspectRatio(1f)
                                    .background(
                                        when {
                                            isDonorDay -> Color.Red
                                            currentDay == currentDate.value.dayOfMonth -> Color.Cyan
                                            else -> Color.Transparent
                                        },
                                        shape = RoundedCornerShape(4.dp)
                                    )
                                    .padding(4.dp)
                            ) {
                                Text(text = currentDay.toString())
                            }
                            currentDay++
                        }
                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun isDonorDay(date: LocalDate): Boolean {
    val startDate = LocalDate.of(2024, 1, 1) // Start date for the first donor day
    val monthsBetween = java.time.temporal.ChronoUnit.MONTHS.between(startDate, date)
    return (monthsBetween % 3).toInt() == 0 && date.dayOfMonth == startDate.dayOfMonth
}
