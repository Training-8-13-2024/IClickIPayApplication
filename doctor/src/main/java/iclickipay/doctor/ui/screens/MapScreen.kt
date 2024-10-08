import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MapScreen(doctorNavController: NavHostController) {
    val pagerState = rememberPagerState()
val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
    HorizontalPager(
        count = items.size,
        state = pagerState,
        modifier = Modifier.fillMaxWidth()
    ) { page ->
        TinderCard(items[page])
    }
}

@Composable
fun TinderCard(item: String) {
    Box(
        modifier = Modifier
            .width(300.dp)
            .height(400.dp)
            .padding(16.dp)
            .background(Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        Text(text = item)
    }
}