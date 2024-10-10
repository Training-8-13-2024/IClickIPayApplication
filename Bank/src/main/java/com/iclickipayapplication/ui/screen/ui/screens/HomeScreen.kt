package com.iclickipayapplication.ui.screen.ui.screens

import android.widget.Toast
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iclickipay.bank.R
import com.iclickipayapplication.ui.screen.data.constants.HORIZONAL_PADDING
import com.iclickipayapplication.ui.screen.data.constants.User
import com.iclickipayapplication.ui.screen.data.constants.VERTICAL_PADDING
import com.iclickipayapplication.ui.screen.ui.components.AtmCard


@Composable
fun HomeScreen() {
    val cvv = remember { mutableStateOf("***") }
    val showCVV = remember { mutableStateOf(false) }
    val borderColor = colorResource(id = R.color.border_grey)
    val clipboardManager: ClipboardManager = LocalClipboardManager.current
    var text = remember { mutableStateOf("")}
    val user = User.DEFAULT_User
    val annotatedString: AnnotatedString
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = VERTICAL_PADDING, horizontal = HORIZONAL_PADDING)
                .weight(.3f)
                .fillMaxWidth(),
        ) {
            Text(text = "Welcome back", color = colorResource(R.color.grey))
            Text(
                text = user.userName,
                color = Color.Black,
                fontSize = 25.sp
            )
        }
        Column(
            modifier = Modifier
                .padding(horizontal = HORIZONAL_PADDING)
                .weight(.4f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column() {
                AtmCard(
                    bankAmount = user.userBalance,
                    bankHolderName = user.userName.split(" ")[1],
                    cardLogo = R.drawable.mastercard_logo_wine,
                    cardBackground = R.color.atm,
                    cvv = cvv.value,
                    cardExpiry = "12/25"
                )
                Spacer(modifier = Modifier.padding(vertical = 10.dp))
                Row(
                    modifier = Modifier
                        .drawBehind {
                            val borderThickness = 3f
                            val y = size.height - borderThickness / 2
                            drawLine(
                                color = borderColor,
                                start = Offset(0f, y),
                                end = Offset(size.width, y),
                                strokeWidth = borderThickness
                            )
                        }
                ) {
                    if (showCVV.value) {
                        TextButton(
                            onClick = {
                                cvv.value = "***"
                                showCVV.value = false
                            },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Transparent,
                                contentColor = Color.Black
                            )
                        ) {
                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = "Hide CVV Code ")
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_lock_open_24),
                                    contentDescription = "arrow"
                                )
                            }
                        }
                    } else {
                        TextButton(
                            onClick = {
                                cvv.value = "523"
                                showCVV.value = true
                            },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Transparent,
                                contentColor = Color.Black
                            )
                        ) {
                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = "Show CVV Code ")
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_lock_outline_24),
                                    contentDescription = "arrow"
                                )
                            }
                        }

                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .weight(.3f)
                .padding(horizontal = HORIZONAL_PADDING)
                .fillMaxWidth(),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Account Number",
                        color = colorResource(R.color.grey),
                        fontWeight = FontWeight.Light
                    )
                    Spacer(modifier = Modifier.padding(vertical = 5.dp))
                    Text(text = user.accountNumber, color = Color.Black, fontSize = 15.sp)
                }
                Icon(
                    painter = painterResource(id = R.drawable.baseline_content_copy_24),
                    contentDescription = "copy",
                    modifier = Modifier.size(20.dp)
                        .clickable {
                            clipboardManager.setText(
                                AnnotatedString(user.accountNumber)
                            )
                            Toast.makeText(context, "Account Number Copied", Toast.LENGTH_SHORT).show()
                        }
                )
            }
            Spacer(modifier = Modifier.padding(vertical = 10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Card Number",
                        color = colorResource(R.color.grey),
                        fontWeight = FontWeight.Light
                    )
                    Spacer(modifier = Modifier.padding(vertical = 5.dp))
                    Text(text = user.cardNumber, color = Color.Black, fontSize = 15.sp)
                }
                Icon(
                    painter = painterResource(id = R.drawable.baseline_content_copy_24),
                    contentDescription = "copy",
                    modifier = Modifier.size(20.dp)
                        .clickable {
                            clipboardManager.setText(
                                AnnotatedString(user.cardNumber)
                            )
                            Toast.makeText(context, "Card Number Copied", Toast.LENGTH_SHORT).show()
                        }
                )
            }
        }
    }
}
