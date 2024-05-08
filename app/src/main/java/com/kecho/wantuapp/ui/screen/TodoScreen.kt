package com.kecho.wantuapp.ui.screen

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kecho.wantuapp.ui.component.todo.ListItemContainer
import com.kecho.wantuapp.ui.component.appbar.DailyTopBar
import com.kecho.wantuapp.ui.component.search.SearchBar
import com.kecho.wantuapp.ui.component.search.SearchState
import com.kecho.wantuapp.ui.component.search.rememberSearchState
import com.kecho.wantuapp.ui.theme.WantuAppTheme
import com.kecho.wantuapp.ui.theme.softYellow
import com.kecho.wantuapp.ui.viewmodel.TodoViewModel
import com.kecho.wantuapp.utils.Constant
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun TodoScreen(
    todoViewModel: TodoViewModel = hiltViewModel(),
    navController: NavController,
    state: SearchState = rememberSearchState()
) {

    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = { DailyTopBar() }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
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
                    todoViewModel.items.value.groupBy { memo ->
                        when (val daysAgo =
                            (Calendar.getInstance().timeInMillis - memo.date) / (1000 * 60 * 60 * 24)) {
                            0L -> "Today"
                            1L -> "Yesterday"
                            in 2L..6L -> "이번 주"
                            7L -> "This week"
                            else -> "$daysAgo days ago"
                        }
                    }.forEach { (date, memos) ->
                        stickyHeader {
                            Text(
                                text = date,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = Color.Black,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp)
                            )
                        }

                        items(memos) { memo ->
                            ListItemContainer(todo = memo,
                                onClick = { todoViewModel.updateIsDone(memo.uid) },
                                onDeleteClick = { todoViewModel.deleteTodo(memo.uid) },
                                onUpdateClick = { todo ->
                                    Log.d("KETEST", "todo : $todo")
                                    navController.currentBackStackEntry?.savedStateHandle?.set("todo", todo)
                                    navController.navigate(Constant.WRITE)
                                }
                            )
                        }
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
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DefaultPreview() {
    WantuAppTheme {
//        TodoScreen(navController = NavConrememberScrollState())
    }
}