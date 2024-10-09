package com.iclickipayapplication.common.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iclickipayapplication.common.constants.GO_BACK
import com.iclickipayapplication.common.constants.HORIZONAL_PADDING
import com.iclickipayapplication.common.constants.ORANGE

@Composable
fun HeaderComponent(
    onClick: () -> Unit,
    headerText: String? = null,
    headerFontSize: Int = 20,
    iconSource: Int = GO_BACK,
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start
){
    Row(
        modifier = modifier,
        horizontalArrangement = horizontalArrangement,
    ) {
        Icon(
            painter = painterResource(id = iconSource),
            contentDescription = "backIcon",
            modifier = Modifier
                .size(32.dp)
                .then(
                    if(headerText != null)
                        Modifier.weight(.07f)
                    else
                        Modifier
                )
                .clickable {
                    onClick()
                },
            tint = colorResource(ORANGE)
        )
        if (headerText != null) {
            Text(
                text = headerText,
                modifier = Modifier.padding(start = 16.dp)
                    .weight(.93f),
                textAlign = TextAlign.Center,
                fontSize = headerFontSize.sp
            )
        }
    }
}