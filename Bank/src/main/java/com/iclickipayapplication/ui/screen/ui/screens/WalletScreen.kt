package com.iclickipayapplication.ui.screen.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iclickipay.bank.R
import com.iclickipayapplication.ui.screen.components.HomeNav
import com.iclickipayapplication.ui.screen.data.models.InnerNav


@Composable
fun WalletScreen() {
    val items = listOf(
        InnerNav.All,
        InnerNav.Sent,
        InnerNav.Received
    )
    val currentItem = remember { mutableStateOf<InnerNav>(InnerNav.All) }
    val HORIZONAL_PADDING = 30.dp
    val VERTICAL_PADDING = 40.dp
    val BALANCE = "926.21"
    val GREY = 0xFFA6AAB4
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(247, 248, 249, 255))
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
                    text = "$ $BALANCE",
                    modifier = Modifier.padding(top = 5.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            }
            Image(
                painter = painterResource(id = R.drawable.photo01),
                contentDescription = "notificationicon",
                modifier = Modifier.width(32.dp)
                    .height(32.dp),
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 20.dp))
        HomeNav(
            items = items,
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
                InnerNav.All -> AllScreen()
                InnerNav.Received -> ReceivedScreen()
                InnerNav.Sent -> SentScreen()
            }
        }
    }
}