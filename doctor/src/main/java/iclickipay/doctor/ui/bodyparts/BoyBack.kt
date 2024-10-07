package iclickipay.doctor.ui.bodyparts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.iclickipay.doctor.R


@Composable
fun BoyBack() {
    Row {
        Image(
            modifier = Modifier
                .height(500.dp)
                .width(100.dp)
                .weight(1f),
            painter = painterResource(id = R.drawable.body_boy_parts_back),
            contentDescription = "Body-boy-parts-front"
        )
    }
}