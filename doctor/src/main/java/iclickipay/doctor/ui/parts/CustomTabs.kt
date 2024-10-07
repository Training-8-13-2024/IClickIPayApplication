package iclickipay.doctor.ui.parts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import iclickipay.doctor.ui.parts.TabSymptoms


@Composable
fun CustomTabs(
) {
    var tabIndex by remember { mutableStateOf(0) }

    val tabs = listOf("Symptoms", "Results", "Summary")

    Column(modifier = Modifier.fillMaxWidth().padding(0.dp),
        verticalArrangement = Arrangement.Center) {
        ScrollableTabRow(selectedTabIndex = tabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(text = { Text(title) },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                   
                )
            }
        }
        when (tabIndex) {
            0 -> TabSymptoms()
            1 -> TabResults()
            2 -> TabSymptoms()
        }
    }
}


@Composable
@Preview
fun CustomTabsPreview() {
    CustomTabs()
}