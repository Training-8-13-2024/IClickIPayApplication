package com.iclickipay.iclickipayapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.iclickipay.iclickipayapplication.R
import com.iclickipay.iclickipayapplication.ui.components.ButtonComponent
import com.iclickipay.iclickipayapplication.ui.components.SwiperComponent
import com.iclickipay.iclickipayapplication.ui.navigation.Navigation

@Composable
fun InfoScreen(
    navController: NavController
) {
    val contentMessages = listOf(
        "Bank & transfer",
        "Messages",
        "Move",
        "Services",
    )
    val contentImages = listOf(
        R.drawable.bank,
        R.drawable.messages,
        R.drawable.move,
        R.drawable.services,
    )
    val index = remember { mutableStateOf(0) }
    val contentHeader = remember { mutableStateOf(contentMessages[index.value]) }
    val contentImage = remember { mutableIntStateOf(contentImages[index.value]) }
    val dragAmount = remember { mutableStateOf(0f) }
    val threshold = 350f
    val density = LocalDensity.current

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(20.dp)
                .fillMaxSize()
                .verticalScroll(state = rememberScrollState())
                .pointerInput(Unit) {
                    detectHorizontalDragGestures { _, dragDelta ->
                        dragAmount.value += dragDelta
                        if (dragAmount.value > threshold) {
                            // Swiping left
                            index.value =
                                if (index.value != 0) (index.value - 1 + contentMessages.size) % contentMessages.size else 0
                            contentHeader.value = contentMessages[index.value]
                            contentImage.value = contentImages[index.value]
                            dragAmount.value = 0f
                        } else if (dragAmount.value < -threshold) {
                            // Swiping right
                            index.value =
                                if (index.value != contentMessages.size - 1) (index.value + 1) % contentMessages.size else contentMessages.size - 1
                            contentHeader.value = contentMessages[index.value]
                            contentImage.value = contentImages[index.value]
                            dragAmount.value = 0f // Reset drag amount
                        }
                    }

                }
        ) {
            if(index.value != contentMessages.size - 1) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                ) {

                    Text(
                        text = "Skip",
                        color = colorResource(R.color.orange),
                        modifier = Modifier
                            .clickable {
                                navController.navigate(Navigation.SIGNUP.name)
                            }
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = contentImage.value),
                    contentDescription = "Image",
                    modifier = Modifier
                        .size(350.dp)
                )
                Text(
                    text = contentHeader.value,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(vertical = 15.dp)
                )
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis lobortis sit amet odio in egestas. Pellen tesque ultricies justo.",
                    fontSize = 18.sp,
                    color = colorResource(R.color.grey),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(vertical = 15.dp)
                )
                Spacer(
                    modifier = Modifier
                        .padding(vertical = 25.dp)
                )

                SwiperComponent(contentMessages.size, index.value)
                if (index.value == 3) {
                    Spacer(
                        modifier = Modifier
                            .padding(vertical = 25.dp)
                    )
                    ButtonComponent(
                        onclick = { navController.navigate(Navigation.SIGNUP.name) },
                        text = "Get Started"
                    )
                    Text(
                        text = "Sign in",
                        color = colorResource(R.color.orange),
                        fontSize = 17.sp,
                        modifier = Modifier
                            .clickable {
                                navController.navigate("login")
                            }
                    )
                }
            }
        }
    }
}