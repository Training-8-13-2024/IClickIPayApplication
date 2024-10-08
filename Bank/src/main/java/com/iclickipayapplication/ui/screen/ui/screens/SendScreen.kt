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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.iclickipay.bank.R
import com.iclickipayapplication.ui.screen.data.constants.HORIZONAL_PADDING
import com.iclickipayapplication.ui.screen.data.models.Bankscreens
import com.iclickipayapplication.ui.screen.ui.components.ButtonComponent
import com.iclickipayapplication.ui.screen.ui.components.CustomScreen
import com.iclickipayapplication.ui.screen.data.models.Dummy
import com.iclickipayapplication.ui.screen.data.models.MoneyOptions
import com.iclickipayapplication.ui.screen.ui.components.MoneyDetailTemplate
import com.iclickipayapplication.ui.screen.ui.viewmodel.TransactionViewModel


@Composable
fun SendScreen(
    transaction: TransactionViewModel = viewModel(),
    goBack: (Bankscreens) -> Unit
) {
    val transactions = transaction.getRegularTransaction()
    val currentScreen = remember { mutableStateOf<MoneyOptions>(MoneyOptions.DEFAULT_SCREEN) }
    Column() {
        when (val screen = currentScreen.value) {
            MoneyOptions.ASK_MONEY -> AskMoneyScreen(
                transaction = transactions,
                onClick = { currentScreen.value = it }
            )

            MoneyOptions.SEND_MONEY -> SendMoneyScreen(
                transaction = transactions,
                onClick = { currentScreen.value = it }

            )

            MoneyOptions.DEFAULT_SCREEN -> DefaultScreen(
                onClick = { currentScreen.value = it },
                goBack = { goBack.invoke(Bankscreens.Home) }
            )

            is MoneyOptions.SEND_MONEY_TO_RECIPIENT -> RecipientScreen(
                currentProfile = screen.sender,
                onBackClick = { currentScreen.value = MoneyOptions.SEND_MONEY },
                amount = screen.amount,
                onFinish = {
                    currentScreen.value = MoneyOptions.END_SCREEN(
                        Transactiontype = "debit",
                        icon = R.drawable.requestsent
                    )
                }
            )

            is MoneyOptions.END_SCREEN -> EndScreen(
                transactionType = screen.Transactiontype,
                icon = screen.icon,
                goHome = { currentScreen.value = MoneyOptions.DEFAULT_SCREEN },
                anotherRequest = { currentScreen.value = MoneyOptions.SEND_MONEY }
            )

            is MoneyOptions.SEND_MONEY_TO_SENDER ->
                SenderScreen(
                    currentProfile = screen.sender,
                    onBackClick = { currentScreen.value = MoneyOptions.SEND_MONEY },
                    amount = screen.amount,
                    onFinish = {
                        currentScreen.value = MoneyOptions.END_SCREEN(
                            Transactiontype = "credit",
                            icon = R.drawable.moneysentfinish
                        )
                    }
                )
        }
    }
}

@Composable
fun DefaultScreen(
    onClick: (MoneyOptions) -> Unit,
    goBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(247, 248, 249, 255))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 40.dp, horizontal = HORIZONAL_PADDING),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "backIcon",
                modifier = Modifier
                    .size(32.dp)
                    .clickable { goBack() })
        }
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
            Text(text = "Select an option", color = Color.Black, fontSize = 25.sp)
            Spacer(modifier = Modifier.padding(vertical = 10.dp))
            Text(
                text = "lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                color = colorResource(R.color.grey),
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
    transaction: List<Dummy>,
    onClick: (MoneyOptions) -> Unit
) {
    var selectedIndex = remember { mutableStateOf(0) }
    val amount = remember { mutableStateOf("") }
    CustomScreen(
        list = transaction,
        Header = "Ask money",
        transactionType = "Debtor",
        onBackClick = { onClick(MoneyOptions.DEFAULT_SCREEN) },
        selectedIndex = selectedIndex.value,
        onButtonClick = {
            onClick(
                MoneyOptions.SEND_MONEY_TO_RECIPIENT(
                    transaction[selectedIndex.value],
                    amount.value
                )
            )
        },
        amount = amount.value,
        onAmountChange = { amount.value = it },
        onSelectedChange = { selectedIndex.value = it }
    )

}


@Composable
fun SendMoneyScreen(
    transaction: List<Dummy>,
    onClick: (MoneyOptions) -> Unit
) {
    var selectedIndex = remember { mutableStateOf(0) }
    val amount = remember { mutableStateOf("") }


    CustomScreen(
        list = transaction,
        Header = "Send Money",
        transactionType = "Creditor",
        onBackClick = { onClick(MoneyOptions.DEFAULT_SCREEN) },
        selectedIndex = selectedIndex.value,
        onButtonClick = {
            onClick(
                MoneyOptions.SEND_MONEY_TO_SENDER(transaction[selectedIndex.value], amount.value)
            )
        },
        amount = amount.value,
        onAmountChange = { amount.value = it },
        onSelectedChange = { selectedIndex.value = it }
    )
}

@Composable
fun EndScreen(
    transactionType: String,
    icon: Int,
    goHome: () -> Unit,
    anotherRequest: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "notificationicon",
            modifier = Modifier.size(350.dp),
        )
        if (transactionType == "credit") {
            Text(
                text = "Money sent",
                color = Color.Black,
                fontSize = 25.sp,
                fontWeight = FontWeight.Light
            )
            Spacer(modifier = Modifier.padding(vertical = 10.dp))
            Text(
                text = "Your recipient will receive your payment",
                color = colorResource(R.color.grey),
                fontWeight = FontWeight.Light
            )
            Column(
                modifier = Modifier
                    .padding(top = 200.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ButtonComponent(
                    onclick = goHome,
                    text = "Go Home"
                )
            }

        } else {
            Text(
                text = "Request sent",
                color = Color.Black,
                fontSize = 25.sp,
                fontWeight = FontWeight.Light
            )
            Spacer(modifier = Modifier.padding(vertical = 10.dp))
            Text(
                text = "Your debtor will receive your request.\nHe has 30 days to honor the latter",
                color = colorResource(R.color.grey),
                lineHeight = 20.sp,
                fontWeight = FontWeight.Light
            )
            Row(
                modifier = Modifier
                    .padding(top = 200.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ButtonComponent(
                    onclick = goHome,
                    text = "Go Home",
                )
                ButtonComponent(
                    onclick = anotherRequest,
                    text = "Ask again",
                    buttonColor = Color(0xFF10C971),
                )
            }
        }
    }

}


@Composable
fun SenderScreen(
    currentProfile: Dummy,
    onBackClick: () -> Unit,
    amount: String,
    onFinish: () -> Unit
) {
    MoneyDetailTemplate(
        currentProfile = currentProfile,
        onBackClick = onBackClick,
        amount = amount,
        header = "Send Money",
        trasactionType = "debit",
        onFinish
    )
}

@Composable
fun RecipientScreen(
    currentProfile: Dummy,
    onBackClick: () -> Unit,
    amount: String,
    onFinish: () -> Unit
) {
    MoneyDetailTemplate(
        currentProfile = currentProfile,
        onBackClick = onBackClick,
        amount = amount,
        header = "Receive Money",
        trasactionType = "credit",
        onFinish
    )

}