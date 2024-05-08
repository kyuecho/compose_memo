package com.kecho.wantuapp.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kecho.wantuapp.ui.component.appbar.DailyTopBar
import com.kecho.wantuapp.ui.theme.WantuAppTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BucketListScreen() {
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = { DailyTopBar() }
    ) {
        Column {
            Text("BucketListScreen")
        }
    }
}

@Preview
@Composable
fun BuckListScreenPreview() {
    WantuAppTheme {
        BucketListScreen()
    }
}