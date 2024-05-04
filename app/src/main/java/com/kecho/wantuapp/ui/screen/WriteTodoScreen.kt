package com.kecho.wantuapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.kecho.wantuapp.ui.theme.navy
import com.kecho.wantuapp.ui.theme.softYellow
import com.kecho.wantuapp.ui.viewmodel.TodoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WriteTodoScreen(
    todoViewModel: TodoViewModel = hiltViewModel(),
    navController: NavHostController
) {
    var memo by rememberSaveable {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            BackTopBar(memo, todoViewModel, navController)
        },
        modifier = Modifier.fillMaxSize(),
    ) { it ->
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(color = softYellow)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BasicTextField(
                    modifier = Modifier.fillMaxSize(),
                    value = memo,
                    onValueChange = { memo = it },
                    textStyle = LocalTextStyle.current.copy(color = Color.Black)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackTopBar(
    memo : String,
    todoViewModel : TodoViewModel,
    navController: NavHostController) {
    TopAppBar(
        title = { Text("메모") },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = navy,
            titleContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = {
                todoViewModel.addTodo(memo)
                navController.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    tint = Color.White,
                    contentDescription = "back"
                )
            }
        }
    )
}