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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.iclickipay.bank.R
import com.iclickipayapplication.ui.screen.components.Input
import com.iclickipayapplication.ui.screen.components.SliderComponent
import com.iclickipayapplication.ui.screen.ui.viewmodel.TransactionViewModel


@Composable
fun SendScreen(
    Transaction: TransactionViewModel = viewModel()
) {
    val list = Transaction.getRegularTransaction()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(247, 248, 249, 255))
    ) {
        val HORIZONAL_PADDING = 30.dp
        val VERTICAL_PADDING = 40.dp
        val GREY = 0xFF757F8C
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 70.dp, horizontal = HORIZONAL_PADDING),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = "Send money",
                color = Color.Black,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

            Image(
                painter = painterResource(id = R.drawable.photo01),
                contentDescription = "notificationicon",
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp),
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = HORIZONAL_PADDING)
        ){
            Text(text = "Enter contact",fontSize = 13.sp, color = Color(GREY))
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            Input(
                inputName = "Name, email or phone number",
                value = "",
                onValueChange = {}
            )
            Spacer(modifier = Modifier.padding(vertical = 20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Creditor",fontSize = 13.sp, color = Color(GREY))
                Text(text = "Show all",fontSize = 13.sp, color = Color(0xFF1140C9))
            }
            SliderComponent(sliders = list)

        }
    }
}