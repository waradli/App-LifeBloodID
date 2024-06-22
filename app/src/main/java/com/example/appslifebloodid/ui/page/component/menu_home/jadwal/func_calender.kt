package com.example.appslifebloodid.ui.page.component.menu_home.jadwal

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appslifebloodid.ui.theme.poppinsFontFamily
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Calendar(modifier: Modifier = Modifier) {
    val currentMonth = remember { mutableStateOf(YearMonth.now()) }
    val selectedDate = remember { mutableStateOf<LocalDate?>(null) }

    Card(
        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 22.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.elevatedCardElevation(10.dp),
        ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            CalendarHeader(
                currentMonth = currentMonth.value,
                onPreviousMonth = { currentMonth.value = currentMonth.value.minusMonths(1) },
                onNextMonth = { currentMonth.value = currentMonth.value.plusMonths(1) }
            )
            Divider(
                modifier = Modifier.padding(vertical = 12.dp),
                thickness = 1.dp,
                color = Color.Black
            )
            CalendarGrid(currentMonth = currentMonth.value, selectedDate = selectedDate.value) {
                selectedDate.value = it
            }

        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarHeader(
    currentMonth: YearMonth,
    onPreviousMonth: () -> Unit,
    onNextMonth: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${
                currentMonth.month.getDisplayName(
                    TextStyle.FULL,
                    Locale.getDefault()
                )
            } ${currentMonth.year}",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontFamily = poppinsFontFamily
        )
        Row {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(Color(0xffb20909))

            ) {
                IconButton(onClick = onPreviousMonth) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Previous Month",
                        modifier = Modifier.size(18.dp, 18.dp),
                        tint = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.width(20.dp))
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(Color(0xffb20909))
            ) {
                IconButton(onClick = onNextMonth) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Next Month",
                        modifier = Modifier.size(18.dp, 18.dp),
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarGrid(
    currentMonth: YearMonth,
    selectedDate: LocalDate?,
    onDateSelected: (LocalDate) -> Unit
) {
    val firstDayOfMonth = currentMonth.atDay(1)
    val firstDayOfWeek = firstDayOfMonth.dayOfWeek.value % 7
    val daysInMonth = currentMonth.lengthOfMonth()

    Column {
        Row(modifier = Modifier.fillMaxWidth()) {
            listOf("Ming", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab").forEach { day ->
                Text(
                    text = day,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppinsFontFamily
                )
            }
        }
        Divider(
            modifier = Modifier.padding(vertical = 10.dp),
            thickness = 1.dp,
            color = Color.Black
        )
        for (week in 0..5) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                for (day in 0..6) {
                    val dayOfMonth = week * 7 + day - firstDayOfWeek + 1
                    if (dayOfMonth in 1..daysInMonth) {
                        val date = currentMonth.atDay(dayOfMonth)
                        DayBox(
                            date = date,
                            isSelected = date == selectedDate,
                            onClick = { onDateSelected(date) }
                        )
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DayBox(
    date: LocalDate,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(47.dp)
            .height(48.dp)
            .aspectRatio(1f)
            .padding(horizontal = 2.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(if (isSelected) Color(0xffb20909) else Color.White)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = date.dayOfMonth.toString(),
            color = if (isSelected) Color.White else Color.Black,
            fontWeight = FontWeight.Bold
        )

    }
}
