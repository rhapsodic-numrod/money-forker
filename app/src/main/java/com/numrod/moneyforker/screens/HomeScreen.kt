package com.numrod.moneyforker.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.numrod.moneyforker.ui.theme.MoneyForkerTheme

@Composable
fun HomeScreen(navController: NavController) {

    Scaffold(
        modifier = Modifier.padding(20.dp),
        topBar = {
            Greeting(name = "Profiliu")
        },

    ) {


        Column(modifier = Modifier.padding(it), verticalArrangement = Arrangement.spacedBy(10.dp)) {

            ShowBudget(180.85)

            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                AccountingCard(100.0, false)
                AccountingCard(50.0, true)
            }

            ActivitySection()
        }
    }
}

@Composable
fun ActivitySection() {
    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "Recent Activity")
            Text(text = "See all")
        }

        ActivitiesList()
    }
}

@Composable
fun ActivitiesList(
    activities: List<String> = listOf("Chip roll", "Kasi Burger", "The Present", "Chip roll")
) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        items(activities) { activity ->
            ActivityCard(activity)
        }
    }
}

@Composable
fun ActivityCard(activity: String) {
    val balance = 14.00
    Surface(color = Color.LightGray, shape = RoundedCornerShape(4.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp, 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(Icons.Filled.Info, contentDescription = "Activity Icon")
            Column {
                Text(text = activity)
                Text(text = "15 January 2024")
            }
            Text(text = String.format("N$ %.2f", balance))
        }
    }
}

@Composable
fun ShowBudget(balance: Double) {
    Column {
        Text(text = String.format("N$ %.2f", balance))
        Text(text = "Remaining Budget")
    }
}

@Composable
fun Greeting(name: String) {
    Column {
        Text(text = "Welcome Back,")
        Text(text = "$name :)")
    }
}

@Composable
fun AccountingCard(balance: Double, isExpense: Boolean) {
    Surface(modifier = Modifier, color = Color.LightGray, shape = RoundedCornerShape(4.dp)) {
        Row(
            modifier = Modifier.padding(12.dp, 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (isExpense) {
                Icon(Icons.Filled.KeyboardArrowDown, contentDescription = "", tint = Color.Red)
            } else {
                Icon(Icons.Filled.KeyboardArrowUp, contentDescription = "", tint = Color.Green)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(text = if (isExpense) "Expense" else "Income")
                Text(text = String.format("N$ %.2f", balance))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MoneyForkerTheme {
        HomeScreen(navController = rememberNavController())
    }
}
