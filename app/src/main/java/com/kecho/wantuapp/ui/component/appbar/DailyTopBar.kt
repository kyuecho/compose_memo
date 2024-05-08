package com.kecho.wantuapp.ui.component.appbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.kecho.wantuapp.ui.theme.navy
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DailyTopBar() {
    val currentDate = LocalDate.now()  // 현재 날짜를 가져옴 val formattedDate =
    val formattedDate =
        currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd(EEE)", Locale.KOREA))

    val text = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Normal, fontSize = 12.sp)) {
            append("Today is ")
        }
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)) {
            append(formattedDate)
        }
        append(" ٩(ˊᗜˋ*)و")
    }
    TopAppBar(
        title = { Text("$text") },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = navy,
            titleContentColor = Color.White
        ),

        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.List,
                    tint = Color.White,
                    contentDescription = "add"
                )
            }
        }
    )
}