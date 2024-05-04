package com.kecho.wantuapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kecho.wantuapp.ui.component.ListItemContainer
import com.kecho.wantuapp.ui.component.SearchBar
import com.kecho.wantuapp.ui.component.SearchState
import com.kecho.wantuapp.ui.component.rememberSearchState
import com.kecho.wantuapp.ui.theme.WantuAppTheme
import com.kecho.wantuapp.ui.theme.softYellow
import com.kecho.wantuapp.ui.viewmodel.TodoViewModel
import com.kecho.wantuapp.utils.Constant

@Composable
fun TodoScreen(
    todoViewModel: TodoViewModel = hiltViewModel(),
    navController: NavController,
    state: SearchState = rememberSearchState()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = softYellow)
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            SearchBar(
                query = state.query,
                onQueryChange = { state.query = it },
                onSearchFocusChange = { state.focused = it },
                onClearQuery = { state.query = TextFieldValue("") },
                onBack = { state.query = TextFieldValue("") },
                searching = state.searching,
                focused = state.focused,
                modifier = Modifier
            )

            LaunchedEffect(state.query) {
                todoViewModel.searchTodos(state.query.text)
            }

            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(todoViewModel.items.value) { item ->
                    ListItemContainer(todo = item,
                        onClick = { todoViewModel.updateIsDone(item.uid) },
                        onDeleteClick = { todoViewModel.deleteTodo(item.uid) })
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .background(Color.White),
                contentAlignment = Alignment.CenterEnd
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "${todoViewModel.items.value.size}개의 메모",
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )
                }
                // memo add
                IconButton(onClick = { navController.navigate(Constant.WRITE) }) {
                    Icon(
                        imageVector = Icons.Filled.Create,
                        tint = Color.Black,
                        contentDescription = "add"
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DefaultPreview() {
    WantuAppTheme {
//        TodoScreen(navController = NavConrememberScrollState())
    }
}