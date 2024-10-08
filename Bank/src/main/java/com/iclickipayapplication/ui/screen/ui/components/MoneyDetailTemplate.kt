package com.iclickipayapplication.ui.screen.ui.components

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.iclickipayapplication.ui.screen.data.models.Dummy


@Composable
fun MoneyDetailTemplate(
    currentProfile: Dummy,
    onBackClick: () -> Unit,
    amount: String,
    header: String,
    trasactionType: String,
    onFinish: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(247, 248, 249, 255))
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 60.dp, horizontal = HORIZONAL_PADDING),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "Back Icon",
                modifier = Modifier
                    .size(32.dp)
                    .fillMaxWidth(.05f)
                    .clickable { onBackClick() },
                tint = colorResource(R.color.orange)
            )
            Text(
                text = header,
                modifier = Modifier
                    .fillMaxWidth(.95f),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
        Column(
            modifier = Modifier
                .padding(horizontal = HORIZONAL_PADDING)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "$ ${amount.toFloat()}",
                    fontSize = 25.sp
                )
                Spacer(modifier = Modifier.padding(vertical = 10.dp))
                SliderItem(
                    item = currentProfile,
                    selected = true,
                    onClick = {}
                )
                Spacer(modifier = Modifier.padding(vertical = 10.dp))
                Text(text = "Transaction fees", fontSize = 13.sp, color = Color(GREY))
                Spacer(modifier = Modifier.padding(vertical = 5.dp))

                Spacer(modifier = Modifier.padding(vertical = 10.dp))
                Text(text = "Total Amount", fontSize = 13.sp, color = Color(GREY))
                Spacer(modifier = Modifier.padding(vertical = 5.dp))
                Text(text = "$ ${amount.toFloat()}", fontSize = 25.sp, color = colorResource(R.color.orange))

                Spacer(modifier = Modifier.padding(vertical = 10.dp))
                Text(text = "Your balance after payment", fontSize = 13.sp, color = Color(GREY))
                Spacer(modifier = Modifier.padding(vertical = 5.dp))
                Text(text = if(trasactionType != "debit") "$ ${User.DEFAULT_User.userBalance.toFloat() + amount.toFloat()}" else "$ ${User.DEFAULT_User.userBalance.toFloat() - amount.toFloat()}", fontSize = 25.sp, color = Color.Black)

            }
            Column(
                modifier = Modifier
                    .padding(top = 200.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Bottom
            ) {
                ButtonComponent(
                    text = "Send",
                    onclick = onFinish,
                    fillwidth = true
                )
            }
        }
    }
}