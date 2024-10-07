package iclickipay.doctor.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke


@Composable
fun CustomProgressIndicator(progress: Float, fillColor: Color, backgroundColor: Color) {
    Canvas(modifier = Modifier.size(width = 25.dp, height = 6.dp)) {
        // Draw the background
        drawRoundRect(
            color = backgroundColor,
            cornerRadius = CornerRadius(8.dp.toPx(), 8.dp.toPx()),
            style = Stroke(width = 2f) // Adjust thickness of the border if needed
        )

        // Draw the progress (filled part)
        drawRoundRect(
            color = fillColor,
            size = this.size.copy(width = this.size.width * progress), // Progress width
            cornerRadius = CornerRadius(8.dp.toPx(), 8.dp.toPx()) // Keep corners rounded
        )
    }
}

@Composable
@Preview
fun CustomProgressIndicatorPreview() {
    CustomProgressIndicator(progress = 0.6f, fillColor = Color.Green, backgroundColor = Color.LightGray)
}