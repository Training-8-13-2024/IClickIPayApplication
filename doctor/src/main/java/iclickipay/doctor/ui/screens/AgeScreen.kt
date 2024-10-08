package iclickipay.doctor.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.iclickipay.doctor.R
import com.iclickipayapplication.common.ui.components.CustomButton
import iclickipay.doctor.ui.DoctorNavigation
import iclickipay.doctor.ui.theme.IClickIPayApplicationDoctorTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgeScreen(
    navController: NavHostController? = null
) {

    IClickIPayApplicationDoctorTheme{
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp, horizontal = 10.dp),
                horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(45.dp)
                        .padding(0.dp),
                    painter = painterResource(id = R.drawable.back_arrow),
                    contentDescription = "Back"
                )
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding))
        {
            var age by remember { mutableStateOf(50) }


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {


                Spacer(modifier = Modifier.height(16.dp))

                // Title Text
                Text(
                    text = "Indicate your age",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(bottom = 32.dp)
                )

                // Age text
                Text(
                    text = age.toString(),
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                // Age picker (buttons and slider)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { if (age > 1) age-- }) {
                        Surface(
                            modifier = Modifier.size(40.dp),
                            shape = CircleShape,
                            color = Color.White,
                            shadowElevation = 4.dp
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(text = "-", fontSize = 24.sp, color = Color.Black)
                            }
                        }
                    }

                    Slider(
                        modifier = Modifier.weight(2f),
                        value = age.toFloat(),
                        onValueChange = { age = it.toInt() },
                        valueRange = 1f..100f,
                        steps = 99,
                        thumb = { thumbValue ->
                            Surface(
                                modifier = Modifier.size(30.dp),
                                shape = CircleShape,
                                color = Color( 0xFFFF6F00),
                                shadowElevation = 4.dp
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Box(
                                        modifier =Modifier
                                            .size(20.dp)
                                            .background(Color(0xFFFFFFFFF), CircleShape)
                                    )
                                }
                            }
                        },
                        colors = SliderDefaults.colors(
                            thumbColor = Color.Transparent,
                            activeTrackColor = Color.Transparent,
                            inactiveTrackColor = Color.Transparent,
                            activeTickColor = Color.LightGray,
                            inactiveTickColor = Color.LightGray
                        ),

                    )

                    IconButton(onClick = { if (age < 100) age++ }) {
                        Surface(
                            modifier = Modifier.size(40.dp),
                            shape = CircleShape,
                            color = Color.White,
                            shadowElevation = 4.dp
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(text = "+", fontSize = 24.sp, color = Color.Black)
                            }
                        }
                    }
                }

                // Next button
                CustomButton(
                    onClick = {
                         navController?.navigate(DoctorNavigation.QUESTIONNAIRE.name)                    },
                    text = "Next",)
            }
        }
    }
}
    }

@Composable
@Preview
fun AgeScreenPrev() {
    AgeScreen()
}