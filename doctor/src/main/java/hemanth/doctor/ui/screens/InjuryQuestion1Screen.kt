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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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


@Composable
fun InjuryQuestion1Screen(doctorNavController: NavHostController? = null) {

    val questions = listOf(
        "Deep, severe and uncontrollable bleeding",
        "Bleeding that is minor, but uncontrollable",
        "Bleeding that is minor and controllable",
    )

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
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            item {
                Spacer(modifier = Modifier.height(20.dp))

                Box(modifier = Modifier)
                {
                    Text(
                        text = "Does your injury have:",
                        color = Color.Black,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.SemiBold,
                        )

                }

                Spacer(modifier = Modifier.height(20.dp))

                Box(modifier = Modifier)
                {
                    Text(text = "Selection is essential",
                        color = Color.Gray,
                                fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                    )
                }
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center
                ) {
                    questions.forEach { question ->
                        Box {
                            QuestionCard(
                                question = question,
                                onClick = {},
                                selected = false
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
            item {
                CustomButton(text = "Next", onClick = {
                    doctorNavController?.navigate("injuryQuestion2")
                })
            }
        }
    }
}


@Composable
fun QuestionCard(question: String, onClick: () -> Unit, selected: Boolean) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(10.dp)
            .background(Color.White)
            .clickable { onClick() }
    ) {
        Card(
            shape = RoundedCornerShape(4.dp),
            elevation = CardDefaults.cardElevation(3.dp),
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = question,
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                )
                Spacer(modifier = Modifier.width(20.dp))
                RadioButton(
                    selected = selected,
                    colors = androidx.compose.material3.RadioButtonDefaults.colors(
                        selectedColor = Color(0xFFFF6F00),
                    ),
                    onClick = {
                    onClick()
                })
            }
        }
    }
}


@Composable
@Preview
fun PreviewInjuryQuestion1Screen() {
    InjuryQuestion1Screen()
}