package com.iclickipay.iclickipayapplication.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType


@Composable
fun Form(
    onFormSubmit: () -> Unit,
    firstName: String,
    onFirstNameChange: (String) -> Unit,
    lastName: String,
    onLastNameChange: (String) -> Unit,
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit
) {
    Column() {
        Input(
            "First Name",
            value = firstName,
            onValueChange = onFirstNameChange
        )
        Input(
            "Last Name",
            value = lastName,
            onValueChange = onLastNameChange
        )
        Input(
            "Email",
            value = email,
            onValueChange = onEmailChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        Input(
            "Password",
            value = password,
            onValueChange = onPasswordChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            ButtonComponent(
                onclick = onFormSubmit,
                text = "Confirm"
            )
        }
    }
}
