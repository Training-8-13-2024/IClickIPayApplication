package com.iclickipayapplication.ui.screen.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iclickipay.bank.R


@Composable
fun AtmCard(
    bankAmount: String,
    cardExpiry: String,
    bankHolderName: String,
    cardLogo: Int,
    cardBackground: Int,
    cvv: String
) {
    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = colorResource(cardBackground))
            .fillMaxWidth()
            .height(220.dp)
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier
                .weight(.3f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Your Balance", color = Color.White, fontWeight = FontWeight.Light
                )
                Spacer(modifier = Modifier.padding(vertical = 5.dp))
                Text(text = "$ $bankAmount", color = Color.White, fontSize = 20.sp)
            }
            Image(painter = painterResource(id = cardLogo), contentDescription = "cardLogo")
        }
        Spacer(modifier = Modifier.weight(.3f))
        Row(
            modifier = Modifier
                .weight(.3f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Card Holder",
                    color = colorResource(R.color.grey),
                    fontWeight = FontWeight.Light
                )
                Spacer(modifier = Modifier.padding(vertical = 5.dp))
                Text(text = bankHolderName, color = Color.White, fontSize = 15.sp)
            }
            Column {
                Text(
                    text = "Expires",
                    color = colorResource(R.color.grey),
                    fontWeight = FontWeight.Light
                )
                Spacer(modifier = Modifier.padding(vertical = 5.dp))
                Text(text = cardExpiry, color = Color.White, fontSize = 15.sp)
            }
            Column {
                Text(
                    text = "CVV",
                    color = colorResource(R.color.grey),
                    fontWeight = FontWeight.Light
                )
                Spacer(modifier = Modifier.padding(vertical = 5.dp))
                Text(text = cvv, color = Color.White, fontSize = 15.sp)
            }
        }

    }

}