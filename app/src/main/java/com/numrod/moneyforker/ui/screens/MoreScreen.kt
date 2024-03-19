package com.numrod.moneyforker.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.numrod.moneyforker.ui.theme.MoneyForkerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreScreen(){
    Scaffold(
        modifier = Modifier.padding(20.dp),
        topBar = {
            TopAppBar(title = { Text(text = "More") })
        },
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)){


            OptionCard("Settings", Icons.Filled.Settings) { /*TODO: Go to settings page*/ }
            OptionCard("Help", Icons.Filled.Info) { /*TODO: Go to help page*/ }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun OptionCard(name: String, icon: ImageVector, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp, 8.dp),
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            Icon(icon, contentDescription = "")
            Text(text = name)
        }
    }
}

@Preview
@Composable
fun MoreScreenPreview(){
    MoneyForkerTheme {
        MoreScreen()
    }
}