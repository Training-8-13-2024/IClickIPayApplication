package com.iclickipayapplication.common.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit
) {
    Row(modifier =Modifier.background(Color(0xFF7A1AFF))) {
        // Button
        TextButton(
            onClick = onClick,
            modifier = Modifier
                .background(Color(0xFF7A1AFF))) {
            Text(text =text, color = MaterialTheme.colorScheme.onTertiary)
        }
    }
}


@Preview
@Composable
fun CustomButtonPreview() {
    CustomButton(
        text = "Custom Button",
        onClick = {}
    )
}