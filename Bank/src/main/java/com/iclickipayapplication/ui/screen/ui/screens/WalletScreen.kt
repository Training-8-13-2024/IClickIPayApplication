package com.iclickipayapplication.ui.screen.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iclickipay.bank.R
import com.iclickipayapplication.ui.screen.data.constants.GREY
import com.iclickipayapplication.ui.screen.data.constants.HORIZONAL_PADDING
import com.iclickipayapplication.ui.screen.data.constants.User
import com.iclickipayapplication.ui.screen.data.interfaces.NavigationIntBank
import com.iclickipayapplication.ui.screen.data.models.Dummy
import com.iclickipayapplication.ui.screen.data.models.InnerNav
import com.iclickipayapplication.ui.screen.data.models.WalletScreenMore
import com.iclickipayapplication.ui.screen.ui.components.Tabs


@Composable
fun WalletScreen(
    innerPadding: PaddingValues
) {
    val currentScreen =
        remember { mutableStateOf<WalletScreenMore>(WalletScreenMore.DEFAULT_SCREEN) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        when (currentScreen.value) {
            WalletScreenMore.DEFAULT_SCREEN -> DefaultScreenWallet(
                onClick = {
                    currentScreen.value = WalletScreenMore.MORE_INFO(transaction = it)
                }
            )

            is WalletScreenMore.MORE_INFO -> MoreInfoScreen(
                onBackClick = { currentScreen.value = WalletScreenMore.DEFAULT_SCREEN },
                currentTransaction = (currentScreen.value as WalletScreenMore.MORE_INFO).transaction!!
            )
        }
    }

}

@Composable
fun MoreInfoScreen(
    onBackClick: () -> Unit,
    currentTransaction: Dummy
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(247, 248, 249, 255))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 70.dp, horizontal = HORIZONAL_PADDING),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "backIcon",
                modifier = Modifier
                    .size(32.dp)
                    .clickable { onBackClick() }
            )
            Text(
                text = "Transaction Details",
                modifier = Modifier
                    .weight(.97f),
                fontSize = 25.sp,
                textAlign = TextAlign.Center
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = HORIZONAL_PADDING),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = currentTransaction.userImage),
                contentDescription = "notificationicon",
                modifier = Modifier.size(75.dp),
            )
            Spacer(modifier = Modifier.padding(vertical = 10.dp))
            Text(text = currentTransaction.ReceipientName, color = Color.Black, fontSize = 20.sp)
            Text(text = currentTransaction.Date, color = colorResource(R.color.grey), fontSize = 15.sp)
            Spacer(modifier = Modifier.padding(vertical = 10.dp))
            Text(text ="Number", color = colorResource(R.color.grey), fontSize = 15.sp)
            Text(text = currentTransaction.id, color = Color.Black, fontSize = 18.sp)
            Spacer(modifier = Modifier.padding(vertical = 10.dp))
            Text(text = "VAT", color = colorResource(R.color.grey), fontSize = 15.sp)
            Text(text = currentTransaction.VAT, color = Color.Black, fontSize = 18.sp)
            Spacer(modifier = Modifier.padding(vertical = 10.dp))
            Text(text = "Transaction Fees", color = colorResource(R.color.grey), fontSize = 15.sp)
            Text(text = "$ 0.00", color = Color.Black, fontSize = 15.sp)
            Spacer(modifier = Modifier.padding(vertical = 10.dp))
            Text(text = "Total Amount", color = colorResource(R.color.grey), fontSize = 15.sp)
            Text(text = "$ ${currentTransaction.Amount}", color = Color.Black, fontSize = 18.sp)
        }
    }
}


@Composable
fun DefaultScreenWallet(
    onClick: (Dummy) -> Unit
) {
    val tabItems = listOf(
        InnerNav.All,
        InnerNav.Sent,
        InnerNav.Received
    )
    val currentItem = remember { mutableStateOf<NavigationIntBank>(InnerNav.All) }
    val threshold = 300f
    val dragAmount = remember { mutableStateOf(0f) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .pointerInput(Unit) {
                detectHorizontalDragGestures { change, dragDelta ->
                    dragAmount.value += dragDelta
                    if (dragAmount.value > threshold) {
                        currentItem.value =
                            if (tabItems.indexOf(currentItem.value) == 0) tabItems[0] else tabItems[tabItems.indexOf(
                                currentItem.value
                            ) - 1]
                        dragAmount.value = 0f
                    } else if (dragAmount.value < -threshold) {
                        currentItem.value =
                            if (tabItems.indexOf(currentItem.value) == tabItems.size - 1) tabItems[tabItems.size - 1] else tabItems[tabItems.indexOf(
                                currentItem.value
                            ) + 1]
                        dragAmount.value = 0f

                    }
                }
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 40.dp, horizontal = HORIZONAL_PADDING),
            horizontalArrangement = Arrangement.End
        ) {
            Image(
                painter = painterResource(id = R.drawable.filtericon),
                contentDescription = "filtericon"
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = HORIZONAL_PADDING),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Column {
                Text(
                    text = "Your balance",
                    color = Color(GREY),
                    fontSize = 12.sp
                )
                Text(
                    text = "$ ${User.DEFAULT_User.userBalance}",
                    modifier = Modifier.padding(top = 5.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            }
            Image(
                painter = painterResource(id = R.drawable.photo01),
                contentDescription = "notificationicon",
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp),
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 20.dp))
        Tabs(
            items = tabItems,
            currentScreen = currentItem.value,
            onScreenSelected = {
                currentItem.value = it
            }
        )
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = HORIZONAL_PADDING)
        ) {

            when (currentItem.value) {
                InnerNav.All -> AllScreen(
                    onClick = {
                        onClick(it)
                    }
                )

                InnerNav.Received -> ReceivedScreen(
                    onClick = {
                        onClick(it)
                    }
                )
                InnerNav.Sent -> SentScreen(
                    onClick = {
                        onClick(it)
                    }
                )
            }
        }
    }
}

