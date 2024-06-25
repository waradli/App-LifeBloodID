package com.example.appslifebloodid.ui.page.component.menu_home.chat

import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.appslifebloodid.R
import com.example.appslifebloodid.ui.theme.poppinsFontFamily
import com.google.accompanist.insets.navigationBarsWithImePadding

data class ChatMessage(val text: String, val isSentByCurrentUser: Boolean, val timestamp: String)

@Composable
fun ScreenChat(
    modifier: Modifier = Modifier,
    navController: NavController,
    username: String
) {
    var messageText by remember { mutableStateOf("") }
    val messages = remember {
        mutableStateListOf(
            ChatMessage(
                "Halo Selamat Pagi dok, Saya Izin Bertanya mengenai donor darah",
                true,
                "10:13"
            ),
            ChatMessage("Selamat Pagi, Ada yang bisa saya bantu ?", false, "10:13"),
            ChatMessage("Ini saya sampai kapan disuntik pak?", true, "10:15")
        )
    }

    Column(modifier = modifier.fillMaxSize()) {
        Header(navController, username)
        ChatContent(messages, Modifier.weight(1f))
        ChatInput(
            messageText = messageText,
            onMessageTextChanged = { messageText = it },
            onSendClicked = {

                if (messageText.isNotBlank()) {
                    messages.add(ChatMessage(messageText, true, "10:20"))
                    messageText = ""
                }
            },
            modifier = Modifier
                .navigationBarsWithImePadding()
                .padding(8.dp) // Add some padding to avoid touching edges
        )
    }
}

@Composable
fun Header(navController: NavController, username: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 40.dp)
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
            Spacer(modifier = Modifier.width(10.dp))
            Card(
                modifier = Modifier
                    .size(40.dp),
                shape = RoundedCornerShape(25.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_profile),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
            }
            Spacer(modifier = Modifier.width(5.dp))
            Column {
                Text(
                    text = username,
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(2.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .background(Color.Green, RoundedCornerShape(4.dp))
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Online", fontSize = 15.sp, color = Color.White)
                }
            }
        }
    }
}

@Composable
fun ChatContent(messages: List<ChatMessage>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    ) {
        items(messages) { message ->
            ChatMessageItem(message)
        }
    }
}

@Composable
fun ChatMessageItem(message: ChatMessage) {
    val backgroundColor = if (message.isSentByCurrentUser) Color(0xffDCF8C6) else Color.White
    val alignment = if (message.isSentByCurrentUser) Alignment.CenterEnd else Alignment.CenterStart

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        contentAlignment = alignment
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(backgroundColor)
                .padding(10.dp)
        ) {
            Text(text = message.text, fontSize = 16.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(2.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Text(text = message.timestamp, fontSize = 12.sp, color = Color.Gray)
                if (message.isSentByCurrentUser) {
                    Spacer(modifier = Modifier.width(3.dp))
                    Image(
                        painter = painterResource(id = R.drawable.iconread),
                        contentDescription = null,
                        modifier = Modifier.size(15.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ChatInput(
    messageText: String,
    onMessageTextChanged: (String) -> Unit,
    onSendClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val cameraPermission =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                // Handle the camera action
            } else {
                Toast.makeText(context, "Camera permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    val audioPermission =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                // Handle the audio recording action
            } else {
                Toast.makeText(context, "Audio recording permission denied", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    val filePicker =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let {
                // Handle the selected file
            }
        }

    var showExtraOptions by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsWithImePadding()
            .padding(bottom =40.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 5.dp)
        ) {
            IconButton(onClick = { showExtraOptions = !showExtraOptions }) {
                Icon(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = "More options",
                    tint = Color(0xffb20909),
                    modifier = Modifier.size(30.dp)
                )
            }
            OutlinedTextField(
                value = messageText,
                onValueChange = onMessageTextChanged,
                placeholder = {
                    Text(
                        text = "Type a message...",
                        style = TextStyle(
                            fontFamily = poppinsFontFamily,
                            fontSize = 13.sp,
                        )
                    )
                },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp)
                    .padding(start = 10.dp, end = 10.dp)
            )
            IconButton(onClick = onSendClicked) {
                Icon(
                    painter = painterResource(id = R.drawable.send),
                    contentDescription = "Send",
                    tint = Color(0xffb20909),
                    modifier = Modifier.size(30.dp)
                )
            }
        }
        if (showExtraOptions) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFEFEFEF))
                    .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                IconButton(onClick = { filePicker.launch("*/*") }) {
                    Icon(
                        painter = painterResource(id = R.drawable.powerclip),
                        contentDescription = "Upload",
                        tint = Color(0xffb20909),
                        modifier = Modifier.size(30.dp)
                    )
                }
                IconButton(onClick = {
                    if (ContextCompat.checkSelfPermission(
                            context,
                            Manifest.permission.CAMERA
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        // Handle the camera action
                    } else {
                        cameraPermission.launch(Manifest.permission.CAMERA)
                    }
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.camera),
                        contentDescription = "Camera",
                        tint = Color(0xffb20909),
                        modifier = Modifier.size(30.dp)
                    )
                }
                IconButton(onClick = {
                    if (ContextCompat.checkSelfPermission(
                            context,
                            Manifest.permission.RECORD_AUDIO
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        // Handle the audio recording action
                    } else {
                        audioPermission.launch(Manifest.permission.RECORD_AUDIO)
                    }
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.voice),
                        contentDescription = "Audio",
                        tint = Color(0xffb20909),
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }
    }
}
