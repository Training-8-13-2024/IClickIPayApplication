package iclickipay.doctor.ui.components


import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iclickipayapplication.common.constants.COLOR_GREY


@Composable
fun InputComponentDoctor(
    inputName: String,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    singleLine: Boolean = false,
    isError: Boolean = false,
    inputHeight: Int = 50,
    leadingIcon: @Composable (() -> Unit)? = null,
    onItemClick: () -> Unit
) {
    val grey = COLOR_GREY
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        placeholder = { Text(text = inputName, fontSize = 13.sp) },
        leadingIcon = leadingIcon?.let {
            {
                Box(modifier = Modifier.clickable { onItemClick() }) {
                    leadingIcon()
                }
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(inputHeight.dp)
            .border(shape = ShapeDefaults.Small, color = colorResource(grey), width = 1.dp),
        keyboardOptions = keyboardOptions,
        textStyle = TextStyle(fontSize = 15.sp),
        singleLine = singleLine,
        isError = isError,
        colors = TextFieldColors(
            cursorColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Red,
            disabledTextColor = colorResource(grey),
            errorCursorColor = Color.Red,
            errorLabelColor = Color.Red,
            errorLeadingIconColor = Color.Red,
            errorTrailingIconColor = Color.Red,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            disabledContainerColor = colorResource(grey),
            disabledLabelColor = Color.Transparent,
            disabledLeadingIconColor = Color.Black,
            disabledTrailingIconColor = Color.Black,
            unfocusedLeadingIconColor = Color.Black,
            focusedLeadingIconColor = Color.Black,
            disabledPlaceholderColor = colorResource(grey),
            disabledPrefixColor = colorResource(grey),
            disabledSuffixColor = colorResource(grey),
            disabledSupportingTextColor = colorResource(grey),
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
            focusedPlaceholderColor = colorResource(grey),
            unfocusedLabelColor = Color.Black,
            unfocusedPlaceholderColor = colorResource(grey)
        )
    )
}
