package com.iclickipayapplication.ui.screen.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.iclickipay.bank.R


@Composable
fun SearchInput(
    query: String,
    onQueryChanged: (String) -> Unit,
    onSearchTriggered: () -> Unit
) {
    val icon = painterResource(id = R.drawable.baseline_search_24)
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        TextField(
            value = query,
            shape = shapes.small.copy(all = CornerSize(20.dp)),
            onValueChange = onQueryChanged,
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "Search transaction") },
            trailingIcon = {
                Icon(
                    painter = icon,
                    contentDescription = "searchicon"
                )
            },
            singleLine = true,
            colors = TextFieldColors(
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
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
                focusedLeadingIconColor = colorResource(R.color.grey),
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
                focusedContainerColor = Color(0xFFF0F1F4),
                focusedPrefixColor = Color.Black,
                focusedSuffixColor = Color.Black,
                focusedSupportingTextColor = Color.Black,
                focusedTrailingIconColor = colorResource(R.color.grey),
                textSelectionColors = TextSelectionColors(
                    handleColor = Color.Black, backgroundColor = Color.Black.copy(alpha = 0.4f)
                ),
                unfocusedContainerColor = Color(0xFFF0F1F4),
                unfocusedPrefixColor = Color.Black,
                unfocusedSuffixColor = Color.Black,
                unfocusedSupportingTextColor = Color.Black,
                unfocusedTrailingIconColor = colorResource(R.color.grey),
                focusedLabelColor = Color.Black,
                focusedPlaceholderColor = Color.Black,
                unfocusedLabelColor = Color.Black,
                unfocusedPlaceholderColor = colorResource(R.color.grey)
            )
        )
    }
}