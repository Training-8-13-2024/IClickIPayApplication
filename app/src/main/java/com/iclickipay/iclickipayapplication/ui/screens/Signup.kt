package com.iclickipay.iclickipayapplication.ui.screens

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.iclickipay.iclickipayapplication.R
import com.iclickipay.iclickipayapplication.ui.components.Form


@Composable
fun SignUpScreen(
    navController: NavController
){
    val firstName = remember { mutableStateOf("") }
    val lastName = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val phoneNumber = remember { mutableStateOf("") }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(vertical = 20.dp, horizontal = 10.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                    contentDescription = "Back",
                    tint = colorResource(R.color.orange),
                    modifier = Modifier
                        .weight(.08f)
                        .clickable {
                            navController.popBackStack()
                        }
                )
                Text(
                    text = "Complete the form",
                    fontSize = 25.sp,
                    modifier = Modifier
                        .weight(.92f),
                    textAlign = TextAlign.Center
                )
            }
            Spacer(
                modifier = Modifier
                    .padding(vertical = 10.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.signup),
                    contentDescription = "Image",
                    modifier = Modifier
                        .size(300.dp)
                )
            }
            Spacer(
                modifier = Modifier
                    .padding(vertical = 10.dp)
            )
            Form(
                onFormSubmit = {},
                firstName = firstName.value,
                onFirstNameChange = { firstName.value = it },
                lastName = lastName.value,
                onLastNameChange = { lastName.value = it },
                email = email.value,
                onEmailChange = { email.value = it },
                phoneNumber = phoneNumber.value,
                onPhoneNumberChange = { phoneNumber.value = it }
            )
        }
    }
}