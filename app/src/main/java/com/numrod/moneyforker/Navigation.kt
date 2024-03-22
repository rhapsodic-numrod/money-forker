package com.numrod.moneyforker

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.numrod.moneyforker.accounting.presentation.AccountsScreen
import com.numrod.moneyforker.accounting.presentation.AddAccountingScreen
import com.numrod.moneyforker.screens.HomeScreen
import com.numrod.moneyforker.screens.MoreScreen
import com.numrod.moneyforker.screens.SettingsScreen

@Composable
fun AppNavHost(
    modifier: Modifier,
    navController: NavHostController,
    startDestination : String = NavItem.Home.route

) {
    NavHost(modifier = modifier, navController = navController, startDestination = startDestination){
        composable(NavItem.Home.route){
            HomeScreen(navController)
        }
        composable(NavItem.Accounting.route){
            AccountsScreen(navController)
        }
        composable(NavItem.AddAccounting.route){
            AddAccountingScreen(navController)
        }
        composable(NavItem.More.route){
            MoreScreen(navController)
        }
        composable(NavItem.Settings.route){
            SettingsScreen(navController)
        }
    }
}

enum class Screen{
    HOME,
    ACCOUNTING,
    ADDACCOUNTING,
    MORE,
    SETTINGS
}

sealed class NavItem(val route: String, val name: String? = null, val icon: ImageVector? = null){
    object Home: NavItem(Screen.HOME.name, "Home", Icons.Filled.Home)
    object Accounting: NavItem(Screen.ACCOUNTING.name, "Accounting", Icons.Filled.Info)
    object More: NavItem(Screen.MORE.name, "More", Icons.Filled.MoreVert)
    object AddAccounting: NavItem(Screen.ADDACCOUNTING.name)
    object Settings: NavItem(Screen.SETTINGS.name)
}

