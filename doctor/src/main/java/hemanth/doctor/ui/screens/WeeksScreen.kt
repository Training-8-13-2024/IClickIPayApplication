package hemanth.doctor.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.iclickipay.doctor.R
import com.iclickipayapplication.common.ui.components.CustomButton
import hemanth.doctor.ui.DoctorNavigation
import hemanth.doctor.ui.theme.IClickIPayApplicationDoctorTheme
import kotlin.math.roundToInt


@Composable
fun WeeksScreen(
    doctorNavController: NavHostController? = null
) {

val colorGradient = listOf(
    Color(0xFFFFDA77),
    Color(0xFFFBCB6F),
    Color(0xFFFBBB6F),
    Color(0xFFFBB26F),
    Color(0xFFFBAA6F),
    Color(0xFFFB996F),
    Color(0xFFFB886F),
    Color(0xFFFB806F),
    Color(0xFFFB6F6F),
    Color(0xFFFC5050))

    var sliderValue by remember { mutableStateOf(10f) }

    IClickIPayApplicationDoctorTheme {
        Scaffold(
            topBar = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .background(Color.White),
                    horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
//                Spacer(modifier =Modifier.height(230.dp).width(10.dp).background(Color.Red))
                    Column {

                        Spacer(modifier = Modifier.padding(10.dp))
                        Image(
                            modifier = Modifier
                                .height(95.dp)
                                .width(55.dp)
                                .padding(10.dp)
                                .clickable { doctorNavController?.popBackStack() },
                            painter = painterResource(id = R.drawable.back_arrow),
                            contentDescription = "Back"
                        )
                    }
                }
            }
        ) { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                item {
                    Text(
                        color = Color.Gray,
                        text = "How severe is your headache?",
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(bottom = 16.dp, top = 10.dp)
                    )

                    Spacer(modifier = Modifier.height(24.dp))
                }

                item{
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Large Number Display
                        Text(
                            text = sliderValue.toInt().toString(),
                            fontSize = 72.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorGradient[sliderValue.toInt() - 1]
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = if (sliderValue < 5) "Weak" else if (sliderValue > 5 && sliderValue < 10) "Strong" else if (sliderValue == 10f) "Unbearable" else "Moderate",
                            fontSize = 24.sp,
                            color = Color(0xFF333333)
                        )
                    }
                }

                item{
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Weak", color = Color(0xFF999999))
                            Text(text = "Strong", color = Color(0xFF999999))
                        }
                        CustomBarSlider(
                            value = sliderValue,
                            onValueChange = { sliderValue = it }
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                }


                item {
                    CustomButton(text = "Next", onClick = {
                        doctorNavController?.navigate(DoctorNavigation.INJURY.name)
                    })
                }
            }
        }

    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomBarSlider(value: Float, onValueChange: (Float) -> Unit) {
    val barCount = 10 // Number of bars
    val barWidth = 24.dp
    val barHeight = 42.dp

    val colorGradient = listOf(
        Color(0xFFFFDA77),
        Color(0xFFFBCB6F),
        Color(0xFFFBBB6F),
        Color(0xFFFBB26F),
        Color(0xFFFBAA6F),
        Color(0xFFFB996F),
        Color(0xFFFB886F),
        Color(0xFFFB806F),
        Color(0xFFFB6F6F),
        Color(0xFFFC5050))
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Gradient bars
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(barHeight * 1.5f)
                .padding(horizontal = 20.dp)
        ) {
            // Draw bars
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (i in 1..barCount) {
                    // Each bar
                    Box(
                       if (i <= value.toInt()) Modifier.width(barWidth)
                        .height(barHeight)
                        .background(
                            color = colorGradient[i - 1],
                            if(i == 1) RoundedCornerShape(topStart = 4.dp, bottomStart = 4.dp) else if(i == 10) RoundedCornerShape(topEnd = 4.dp, bottomEnd = 4.dp) else RoundedCornerShape(0.dp)
                        )
                        else Modifier.width(barWidth)
                            .height(barHeight)
                            .background(
                                Color(0xFFE0E0E0),
                                if(i == 1) RoundedCornerShape(topStart = 4.dp, bottomStart = 4.dp)else if(i == 10) RoundedCornerShape(topEnd = 4.dp, bottomEnd = 4.dp) else RoundedCornerShape(0.dp)

                            )
                    )
                }
            }
        }



        // Slider
        Slider(
            value = value,
            onValueChange = onValueChange,
            valueRange = 1f..10f,
            steps = 8,
            modifier = Modifier.padding(horizontal = 16.dp),
            colors = SliderDefaults.colors(
                thumbColor = Color.Transparent,
                activeTrackColor = Color.Transparent, // Hide track to show bars
                inactiveTrackColor = Color.Transparent
            ),
            enabled = true,
            thumb = {
                value.roundToInt().let { thumbValue ->
                    Box(
                    ) {
                        Text(
                            text = thumbValue.toString(),
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        )
    }
}


@Composable
@Preview
fun WeeksScreenPrev() {
    WeeksScreen()
}