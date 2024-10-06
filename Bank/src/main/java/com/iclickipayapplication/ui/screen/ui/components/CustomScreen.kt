package com.iclickipayapplication.ui.screen.ui.components

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.iclickipay.bank.R
import com.iclickipayapplication.ui.screen.data.models.Dummy

@Composable
fun CustomScreen(
    list: List<Dummy>,
    Header: String,
    transactionType: String,
    onBackClick: () -> Unit,
    onButtonClick: () -> Unit,
    selectedIndex: Int = 0,
    onSelectedChange: (Int) -> Unit,
    amount: String,
    onAmountChange: (String) -> Unit
) {
    val s = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color(0xFF757F8C))) {
            append("Description")
        }
        withStyle(style = SpanStyle(color = Color(0x70757F8C))) {
            append(" (optional)")
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(247, 248, 249, 255))
            .verticalScroll(rememberScrollState())
    ) {
        val HORIZONAL_PADDING = 30.dp
        val VERTICAL_PADDING = 40.dp
        val GREY = 0xFF757F8C


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 40.dp, horizontal = HORIZONAL_PADDING),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "backIcon",
                modifier = Modifier
                    .size(32.dp)
                    .clickable { onBackClick() }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = HORIZONAL_PADDING),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = Header,
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
        ) {
            Text(text = "Enter contact", fontSize = 13.sp, color = Color(GREY))
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
                Text(text = transactionType, fontSize = 13.sp, color = Color(GREY))
                if (list.size > 7) Text(
                    text = "Show all",
                    fontSize = 13.sp,
                    color = Color(0xFF1140C9)
                )
            }
            SliderComponent(
                sliders = list,
                selectedIndex = selectedIndex,
                onClick = onSelectedChange
            )
            Spacer(modifier = Modifier.padding(vertical = 10.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(text = "Transaction details", fontSize = 13.sp, color = Color(GREY))
                Spacer(modifier = Modifier.padding(bottom = 5.dp))
                Input(
                    inputName = "Amount",
                    value = amount,
                    onValueChange = onAmountChange,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Spacer(modifier = Modifier.padding(bottom = 10.dp))
                Input(
                    inputName = s.toString(),
                    value = "",
                    onValueChange = {},
                    singleLine = false,
                    inputHeight = 200
                )
                Spacer(modifier = Modifier.padding(bottom = 18.dp))
                ButtonComponent(
                    text = "Next",
                    onclick = onButtonClick,
                    fillwidth = true,
                    enabled = amount.isNotEmpty() && amount.toFloatOrNull() != null
                )
            }

        }
    }
}