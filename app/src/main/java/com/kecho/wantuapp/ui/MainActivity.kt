package com.kecho.wantuapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kecho.wantuapp.ui.component.BottomNavItem
import com.kecho.wantuapp.ui.screen.BucketListScreen
import com.kecho.wantuapp.ui.screen.TodoScreen
import com.kecho.wantuapp.ui.screen.WriteTodoScreen
import com.kecho.wantuapp.ui.theme.WantuAppTheme
import com.kecho.wantuapp.ui.theme.navy
import com.kecho.wantuapp.utils.Constant
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WantuAppTheme {
                val navController = rememberNavController()
                ScaffoldTrigger(navController)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldTrigger(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopBar()
        },
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigation(
                containerColor = Color.White,
                navController = navController
            )
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            NavigationGraph(
                navController = navController
            )
        }
    }
}

@Composable
fun NavigationGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = BottomNavItem.Todo.screenRoute) {
        composable(BottomNavItem.Todo.screenRoute) {
            TodoScreen(navController = navController)
        }
        composable(BottomNavItem.BucketList.screenRoute) {
            BucketListScreen()
        }
        composable(Constant.WRITE) {
            WriteTodoScreen(navController = navController)
        }
    }
}

@Composable
private fun BottomNavigation(
    modifier: Modifier = Modifier,
    containerColor: Color,
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val items = listOf(
        BottomNavItem.Todo,
        BottomNavItem.BucketList,
    )

    AnimatedVisibility(
        visible = items.map { it.screenRoute }.contains(currentRoute)
    ) {
        NavigationBar(
            modifier = modifier,
            containerColor = containerColor
        ) {
            items.forEach { item ->
                val isSelected = currentRoute == item.screenRoute

                NavigationBarItem(
                    selected = isSelected,
                    label = {
                        Text(
                            text = stringResource(id = item.title),
                            style = TextStyle(fontSize = 12.sp),
                        )
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = stringResource(id = item.title),
                        )
                    },
                    onClick = {
                        navController.navigate(item.screenRoute) {
                            navController.graph.startDestinationRoute?.let {
                                popUpTo(it) { saveState = true }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = MaterialTheme.colorScheme.inverseOnSurface,
                        selectedIconColor = Color.Red,
                        selectedTextColor = Color.Red,
                        unselectedIconColor = Color.Black,
                        unselectedTextColor = Color.Black
                    )
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
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
