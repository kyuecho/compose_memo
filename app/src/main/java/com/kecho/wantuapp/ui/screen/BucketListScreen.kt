package com.kecho.wantuapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kecho.wantuapp.ui.theme.WantuAppTheme

@Composable
fun BucketListScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text("BucketListScreen")
    }
}

@Preview
@Composable
fun BuckListScreenPreview() {
    WantuAppTheme {
        BucketListScreen()
    }
}