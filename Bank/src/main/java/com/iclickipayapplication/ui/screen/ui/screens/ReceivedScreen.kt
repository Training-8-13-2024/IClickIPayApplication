package com.iclickipayapplication.ui.screen.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.iclickipayapplication.ui.screen.components.SearchInput
import com.iclickipayapplication.ui.screen.components.TransactionCard
import com.iclickipayapplication.ui.screen.ui.viewmodel.TransactionViewModel


@Composable
fun ReceivedScreen(
    TranactionViewModel: TransactionViewModel = viewModel()
) {
    val transactions = TranactionViewModel.getTransaction("credit")
    Column {
        SearchInput(
            query = "",
            onQueryChanged = {},
            onSearchTriggered = {}
        )
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        transactions.forEach { (date, transactions) ->
            Text(text = date)
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            transactions.forEach { transaction ->
                Column {
                    Spacer(modifier = Modifier.padding(vertical = 5.dp))
                    TransactionCard(transaction = transaction)
                }
            }
            Spacer(modifier = Modifier.padding(vertical = 10.dp))
        }
    }
}