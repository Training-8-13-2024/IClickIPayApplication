package com.iclickipayapplication.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.iclickipay.bank.R
import com.iclickipayapplication.ui.screen.data.models.Dummy

@Composable
fun TransactionCard(
    transaction: Dummy,
    showInfo: Boolean = true
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = transaction.userImage),
                modifier = Modifier.size(32.dp),
                contentDescription = "userimage",
            )
            Spacer(modifier = Modifier.padding(horizontal = 10.dp))
            Column {
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(color = colorResource(R.color.grey))) {
                            append("to: ")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = Color.Black,
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append(transaction.ReceipientName)
                        }
                    }
                )
                Text(text = transaction.Date, color = colorResource(R.color.grey))
            }
        }
        Row {
            if (!showInfo) {
                Text(
                    text = transaction.Amount.toString(),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
            else {
                Text(
                    text = if(transaction.TransactioType == "credit") "+ $ ${transaction.Amount}" else "- $ ${transaction.Amount}",
                    color = if(transaction.TransactioType == "credit") Color.Green else Color.Red,
                    fontWeight = FontWeight.Bold
                )
            }
        }

    }
}