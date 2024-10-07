package iclickipay.doctor.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.iclickipay.doctor.R
import com.iclickipayapplication.common.ui.components.CustomButton
import iclickipay.doctor.ui.DoctorNavigation
import iclickipay.doctor.ui.components.QuestionCardMultipleCh
import iclickipay.doctor.ui.theme.IClickIPayApplicationDoctorTheme


@Composable
fun InjuryQuestion2Screen(doctorNavController: NavHostController? = null) {


    val questions = listOf(
        "Caused by violent force, causing a penetrating injury, open fracture or organ herniation",
        "Causing intense and unbearable pain in the injured area"
    )

    // Store the selected answer for each question
    var selectedAnswers = remember { mutableStateMapOf<String, String>() }

    IClickIPayApplicationDoctorTheme {
        Scaffold(
            topBar = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 15.dp, horizontal = 10.dp),
                    horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier
                            .size(45.dp)
                            .padding(0.dp)
                            .clickable { doctorNavController?.popBackStack() },
                        painter = painterResource(id = R.drawable.back_arrow),
                        contentDescription = "Back"
                    )
                }
            }
        ) { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    Text(
                        text = "Would you describe your injury in any of the following ways?",
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.padding(bottom = 16.dp, top = 0.dp)
                    )
                }
                items(questions) { question ->

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        QuestionCardMultipleCh(
                            question = question,
                            selectedAnswer = selectedAnswers[question] ?: "Yes",
                            onAnswerSelected = { answer ->
                                selectedAnswers[question] = answer
                            }
                        )
                    }
                }

                // Button for "Next" at the bottom
                item {
                    CustomButton(text = "Next", onClick = {
                        doctorNavController?.navigate(DoctorNavigation.REQUIREATTENTION.name)
                    })
                }
            }
        }

    }
}


@Composable
@Preview
fun PreviewInjuryQuestion2Screen() {
    InjuryQuestion2Screen()
}