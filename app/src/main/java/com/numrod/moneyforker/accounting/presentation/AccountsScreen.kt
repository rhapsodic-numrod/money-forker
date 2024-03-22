package com.numrod.moneyforker.accounting.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.numrod.moneyforker.NavItem
import com.numrod.moneyforker.screens.ActivitiesList
import com.numrod.moneyforker.ui.theme.MoneyForkerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountsScreen(navController: NavController) {
    Scaffold (
        modifier = Modifier.padding(20.dp),
        topBar = {
            CenterAlignedTopAppBar(title = { Text(text = "Expenses") }, )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(NavItem.AddAccounting.route)
                }, shape = CircleShape) {
                Icon(Icons.Filled.Add, contentDescription="add expense icon", tint = Color.Black)
            }
        },

    ){ innerPadding ->

        Column(modifier = Modifier.padding(innerPadding), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row (modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = "Daily")
                Text(text = "Weekly")
                Text(text = "Monthly")
            }

            AccountingGraph(true)

            ActivitiesList()
        }
    }
}

@Composable
fun AccountingGraph(isExpenses: Boolean) {
    Surface (modifier = Modifier
        .fillMaxWidth()
        .height(150.dp), border = BorderStroke(2.dp, Color.DarkGray)) {
        Text(text = "insert graph here")
    }
}

@Preview(showBackground = true)
@Composable
fun AccountsScreenPreview() {
    MoneyForkerTheme {
        AccountsScreen(navController = rememberNavController())
    }
}