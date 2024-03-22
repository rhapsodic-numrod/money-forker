package com.numrod.moneyforker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.numrod.moneyforker.ui.theme.MoneyForkerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MoneyForkerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val screens = listOf(NavItem.Home, NavItem.Accounting, NavItem.More)

    Scaffold (
                bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                screens.forEach{screen ->
                    currentDestination?.hierarchy?.any{ it.route == screen.route }?.let {
                        NavigationBarItem(
                            icon = { Icon(screen.icon!!, contentDescription = "") },
                            label = { Text(text = screen.name!!)},
                            selected = it,
                            onClick = {
                                navController.navigate(screen.route){
                                    popUpTo(navController.graph.startDestinationId){
                                        saveState = true
                                    }

                                    launchSingleTop = true

                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }){
        AppNavHost(modifier = modifier.padding(it), navController = navController)

    }
}