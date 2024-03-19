package com.numrod.moneyforker.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.numrod.moneyforker.ui.theme.MoneyForkerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAccountingScreen() {

    Scaffold(
        modifier = Modifier
            .padding(20.dp),
        topBar = {
            TopAppBar(title = { Text(text = "Add Expense") }, navigationIcon = {
                IconButton(onClick = { /*TODO: Go back to accounting page*/ }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "")
                }
            })
        }
    ) {
        var descriptionField by rememberSaveable { mutableStateOf("") }
        //    var categoryField by rememberSaveable { mutableStateOf("") }
        var amountField by rememberSaveable { mutableStateOf("") }
        Column(
            modifier = Modifier.fillMaxSize().padding(it),
            verticalArrangement = Arrangement.spacedBy(6.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = descriptionField,
                onValueChange = { descriptionField = it },
                label = {
                    Text(
                        text = "Description"
                    )
                })

    //        DropdownMenu(expanded = true, onDismissRequest = { /*TODO*/ }) {
    //            Text(text = "Category")
    //            Text(text = "Category")
    //            Text(text = "Category")
    //            Text(text = "Category")
    //            }

            OutlinedTextField(
                value = amountField,
                onValueChange = { amountField = it },
                label = { Text(text = "Amount (N$)") })

            Button(onClick = { /*TODO*/ }, shape = RoundedCornerShape(6.dp)) {
                Text(text = "Add")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddAccountingScreenPreview() {
    MoneyForkerTheme {
        AddAccountingScreen()
    }
}