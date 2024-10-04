package com.iclickipay.iclickipayapplication.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iclickipay.iclickipayapplication.R

@Composable
fun Input(
    inputName: String,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    singleLine: Boolean = false,
    isError: Boolean = false
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = inputName, fontSize = 13.sp) },
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(60.dp)
            .border(shape = RectangleShape, color = colorResource(R.color.grey), width = 1.dp),
        keyboardOptions = keyboardOptions,
        singleLine = singleLine,
        isError = isError,
        colors = TextFieldColors(
            cursorColor = Color.Black,
            focusedIndicatorColor = Color.Black,
            unfocusedIndicatorColor = Color.Black,
            disabledIndicatorColor = colorResource(R.color.grey),
            errorIndicatorColor = Color.Red,
            disabledTextColor = colorResource(R.color.grey),
            errorCursorColor = Color.Red,
            errorLabelColor = Color.Red,
            errorLeadingIconColor = Color.Red,
            errorTrailingIconColor = Color.Red,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            disabledContainerColor = colorResource(R.color.grey),
            disabledLabelColor = Color.Transparent ,
            disabledLeadingIconColor = Color.Black,
            disabledTrailingIconColor = Color.Black,
            unfocusedLeadingIconColor = Color.Black,
            focusedLeadingIconColor = Color.Black,
            disabledPlaceholderColor = colorResource(R.color.grey),
            disabledPrefixColor = colorResource(R.color.grey),
            disabledSuffixColor = colorResource(R.color.grey),
            disabledSupportingTextColor = colorResource(R.color.grey),
            errorContainerColor = Color.Red,
            errorPlaceholderColor = Color.Red,
            errorPrefixColor = Color.Red,
            errorSuffixColor = Color.Red,
            errorSupportingTextColor = Color.Red,
            errorTextColor = Color.Red,
            focusedContainerColor = Color.Transparent,
            focusedPrefixColor = Color.Black,
            focusedSuffixColor = Color.Black,
            focusedSupportingTextColor = Color.Black,
            focusedTrailingIconColor = Color.Black,
            textSelectionColors = TextSelectionColors(
                handleColor = Color.Black, backgroundColor = Color.Black.copy(alpha = 0.4f)
            ),
            unfocusedContainerColor = Color.Transparent,
            unfocusedPrefixColor = Color.Black,
            unfocusedSuffixColor = Color.Black,
            unfocusedSupportingTextColor = Color.Black,
            unfocusedTrailingIconColor = Color.Black,
            focusedLabelColor = Color.Black,
            focusedPlaceholderColor = Color.Black,
            unfocusedLabelColor = Color.Black,
            unfocusedPlaceholderColor = Color.Black
        )
    )
}
