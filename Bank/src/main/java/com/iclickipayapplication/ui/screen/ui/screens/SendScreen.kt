package com.iclickipayapplication.ui.screen.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.iclickipay.bank.R
import com.iclickipayapplication.ui.screen.data.constants.BALANCE
import com.iclickipayapplication.ui.screen.ui.components.ButtonComponent
import com.iclickipayapplication.ui.screen.ui.components.CustomScreen
import com.iclickipayapplication.ui.screen.ui.components.SearchInput
import com.iclickipayapplication.ui.screen.ui.components.TransactionCard
import com.iclickipayapplication.ui.screen.data.models.Dummy
import com.iclickipayapplication.ui.screen.data.models.MoneyOptions
import com.iclickipayapplication.ui.screen.ui.components.MoneyDetailTemplate
import com.iclickipayapplication.ui.screen.ui.components.SliderItem
import com.iclickipayapplication.ui.screen.ui.viewmodel.TransactionViewModel


@Composable
fun SendScreen(
    Transaction: TransactionViewModel = viewModel()
) {
    val transactions = Transaction.getRegularTransaction()
    val currentScreen = remember { mutableStateOf<MoneyOptions>(MoneyOptions.DEFAULT_SCREEN) }
    Column() {
        when (val screen = currentScreen.value) {
            MoneyOptions.ASK_MONEY -> AskMoneyScreen(
                Transaction = transactions,
                onClick = { currentScreen.value = it }
            )

            MoneyOptions.SEND_MONEY -> SendMoneyScreen(
                Transaction = transactions,
                onClick = { currentScreen.value = it }

            )

            MoneyOptions.DEFAULT_SCREEN -> DefaultScreen(
                onClick = { currentScreen.value = it },
            )

            is MoneyOptions.SEND_MONEY_TO_RECIPIENT -> RecipientScreen(
                currentProfile = screen.sender,
                onBackClick = { currentScreen.value = MoneyOptions.SEND_MONEY },
                amount = screen.amount
            )
            MoneyOptions.END_SCREEN -> TODO()
            is MoneyOptions.SEND_MONEY_TO_SENDER ->
                SenderScreen(
                    currentProfile = screen.sender,
                    onBackClick = { currentScreen.value = MoneyOptions.SEND_MONEY },
                    amount = screen.amount
                )
        }
    }
}

@Composable
fun DefaultScreen(
    onClick: (MoneyOptions) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(247, 248, 249, 255))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.moneyoptions),
                contentDescription = "notificationicon",
                modifier = Modifier.size(200.dp),
            )
            Text(text = "Select an option", color = Color.Black)
            Text(
                text = "lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            )
            ButtonComponent(
                onclick = { onClick(MoneyOptions.ASK_MONEY) },
                text = "Ask Money"
            )
            ButtonComponent(
                onclick = { onClick(MoneyOptions.SEND_MONEY) },
                text = "Send Money"
            )
        }
    }

}

@Composable
fun AskMoneyScreen(
    Transaction: List<Dummy>,
    onClick: (MoneyOptions) -> Unit
) {
    var selectedIndex = remember { mutableStateOf(0) }
    val amount = remember { mutableStateOf("") }
    CustomScreen(
        list = Transaction,
        Header = "Ask money",
        transactionType = "Debtor",
        onBackClick = { onClick(MoneyOptions.DEFAULT_SCREEN) },
        selectedIndex = selectedIndex.value,
        onButtonClick = {
            onClick(MoneyOptions.SEND_MONEY_TO_RECIPIENT(Transaction[selectedIndex.value], amount.value))
        },
        amount = amount.value,
        onAmountChange = { amount.value = it },
        onSelectedChange = { selectedIndex.value = it }
    )
}

@Composable
fun SendMoneyScreen(
    Transaction: List<Dummy>,
    onClick: (MoneyOptions) -> Unit
) {
    var selectedIndex = remember { mutableStateOf(0) }
    val amount = remember { mutableStateOf("") }


    CustomScreen(
        list = Transaction,
        Header = "Send Money",
        transactionType = "Creditor",
        onBackClick = { onClick(MoneyOptions.DEFAULT_SCREEN) },
        selectedIndex = selectedIndex.value,
        onButtonClick = {
            onClick(
                MoneyOptions.SEND_MONEY_TO_SENDER(Transaction[selectedIndex.value], amount.value)
            )
        },
        amount = amount.value,
        onAmountChange = { amount.value = it },
        onSelectedChange = { selectedIndex.value = it }
    )
}

@Composable
fun SenderScreen(
    currentProfile: Dummy,
    onBackClick: () -> Unit,
    amount: String
) {
    MoneyDetailTemplate(
        currentProfile = currentProfile,
        onBackClick = onBackClick,
        amount = amount,
        header = "Send Money",
        trasactionType = "debit"
    )
}

@Composable
fun RecipientScreen(
    currentProfile: Dummy,
    onBackClick: () -> Unit,
    amount: String
) {
    MoneyDetailTemplate(
        currentProfile = currentProfile,
        onBackClick = onBackClick,
        amount = amount,
        header = "Receive Money",
        trasactionType = "credit"
    )

}