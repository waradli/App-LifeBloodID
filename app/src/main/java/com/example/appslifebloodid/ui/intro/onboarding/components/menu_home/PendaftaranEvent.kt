package com.example.appslifebloodid.ui.intro.onboarding.components.menu_home

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appslifebloodid.data.network.RetrofitInstance
import com.example.appslifebloodid.data.repository.EventRepository
import com.example.appslifebloodid.ui.base.EventRegistrationViewModel
import com.example.appslifebloodid.ui.base.EventViewModel
import com.example.appslifebloodid.ui.base.EventViewModelFactory
import java.util.*

@Composable
fun GenderDropdown(
    selectedGender: String,
    onGenderSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    val genders = listOf("Laki-laki", "Perempuan")

    Box(modifier = Modifier.padding(vertical = 8.dp)) {
        OutlinedTextField(
            value = selectedGender,
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true },
            readOnly = true,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Dropdown Arrow",
                    Modifier.clickable { expanded = true }
                )
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(360.dp)
        ) {
            genders.forEach { gender ->
                DropdownMenuItem(
                    onClick = {
                        onGenderSelected(gender)
                        expanded = false
                    },
                    text = { Text(text = gender) }
                )
            }
        }
    }
}

@Composable
fun DatePickerField(
    label: String,
    selectedDate: String,
    onDateSelected: (String) -> Unit
) {
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = DatePickerDialog(
        LocalContext.current,
        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
            onDateSelected("$selectedDay/${selectedMonth + 1}/$selectedYear")
        }, year, month, day
    )

    OutlinedTextField(
        value = selectedDate,
        onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .clickable { datePickerDialog.show() },
        readOnly = true,

        trailingIcon = {
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = "Calendar Icon",
                Modifier.clickable { datePickerDialog.show() }
            )
        }
    )
}

@Composable
fun PendaftaranEvent(
    navController: NavController
) {
    val repository = EventRepository(RetrofitInstance.api)
    val eventRegistrationViewModel: EventRegistrationViewModel = viewModel(
        factory = EventViewModelFactory(repository)
    )
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
                    text = "Pendaftaran",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 10.dp),
                    color = Color.White
                )
            }
        }

        // Input Fields
        var fullName by remember { mutableStateOf("") }
        var address by remember { mutableStateOf("") }
        var dateOfBirth by remember { mutableStateOf("") }
        var gender by remember { mutableStateOf("") }
        var bloodType by remember { mutableStateOf("") }
        var phoneNumber by remember { mutableStateOf("") }
        var isSuccess by remember { mutableStateOf(false) }

        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Nama", fontWeight = FontWeight.Bold)
            OutlinedTextField(
                value = fullName,
                onValueChange = { fullName = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                singleLine = true
            )

            Text(text = "Alamat", fontWeight = FontWeight.Bold)
            OutlinedTextField(
                value = address,
                onValueChange = { address = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                singleLine = true
            )

            Text(text = "Tanggal Lahir", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            DatePickerField(
                label = "Tanggal Lahir",
                selectedDate = dateOfBirth,
                onDateSelected = { dateOfBirth = it }
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Jenis Kelamin", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(5.dp))
            GenderDropdown(
                selectedGender = gender,
                onGenderSelected = { gender = it }
            )

            Text(text = "Golongan Darah", fontWeight = FontWeight.Bold)
            Row {
                listOf("A", "B", "AB", "O").forEach { blood_Type ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = bloodType == blood_Type,
                            onClick = { bloodType = blood_Type }
                        )
                        Text(text = bloodType)
                    }
                }
            }

                Text(text = "No. Telepon", fontWeight = FontWeight.Bold)
            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(2.dp))
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 2.dp)
            ){
                var Checked by remember{
                    mutableStateOf(false)
                }
                Checkbox(checked = Checked, onCheckedChange = {Checked = it})
                Text(text = "Saya Bersedia mendonorkan darah saya apabila sewaktu-waktu ada yang membutuhkan. ", fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))
            Row (modifier = Modifier.padding(start = 240.dp)){
                Button(
                    onClick = {
                        eventRegistrationViewModel.eventRegistration(
                            fullName,
                            address,
                            dateOfBirth,
                            gender,
                            bloodType,
                            phoneNumber,
                            {
                                isSuccess = true
                            },
                            {
                                // Handle error message here
                            }
                        )
                    },
                    modifier = Modifier
                        .width(100.dp)
                        .height(40.dp)
                    ,colors = ButtonDefaults.buttonColors(Color(0xffB20909))
                ) {
                    Text("Kirim")
                }

                if (isSuccess) {
                    Text("Registration Successful!")
                }
            }
        }
    }
}
