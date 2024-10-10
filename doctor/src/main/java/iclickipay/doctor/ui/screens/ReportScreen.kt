package iclickipay.doctor.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.iclickipay.data.doctor.models.Patient
import iclickipay.doctor.viewmodel.PatientViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportScreen(doctorNavController: NavHostController? = null,
                 viewModel: PatientViewModel = hiltViewModel()
) {


    // Observe the patient data from ViewModel
    val patient by viewModel.patient.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.getAllPatients()
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Your answer", fontSize = 22.sp, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = {
                         doctorNavController?.popBackStack()                    }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start
        ) {
            // Sex and Age Section
            Spacer(modifier = Modifier.height(8.dp) )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text("Sex", fontSize = 18.sp, color = Color.Gray)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = if(patient.gender == 0) "Female" else "Male"
                        , fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
                Column {
                    Text("Age", fontSize = 18.sp, color = Color.Gray)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = patient.age.toString()
                        , fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Symptoms Reported Section
            Text("Symptoms reported", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Column {
                Spacer(modifier = Modifier.height(8.dp) )
                ReportedSymptom(text = "Obesity")
                Spacer(modifier = Modifier.height(8.dp) )
                ReportedSymptom(text = "Recent physical injury")
                Spacer(modifier = Modifier.height(8.dp) )
                ReportedSymptom(text = "Headache")
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Other Symptoms Section
            Text("Other symptoms", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(28.dp))

            // Present Symptoms
            Text("Present:", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Column {
                Spacer(modifier = Modifier.height(8.dp) )
                PresentSymptom(text = "Force majeure")
                Spacer(modifier = Modifier.height(8.dp) )
                PresentSymptom(text = "Mild headaches")
                Spacer(modifier = Modifier.height(8.dp) )
                PresentSymptom(text = "Serious injury, difficulty breathing")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Missing Symptoms
            Text("Missing:", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Column {
                Spacer(modifier = Modifier.height(8.dp) )
                MissingSymptom(text = "Hypertension, over 140 mmHg")
                Spacer(modifier = Modifier.height(8.dp) )
                MissingSymptom(text = "Dizzy")
            }
        }
    }
}

@Composable
fun ReportedSymptom(text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text("•", fontSize = 18.sp, color = Color(0xFFFF6F00))
        Spacer(modifier = Modifier.width(8.dp))
        Text(text, fontSize = 16.sp, color = Color.Gray)
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun PresentSymptom(text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(Icons.Default.Check, contentDescription = "Present", tint = Color(0xFF4CAF50))
        Spacer(modifier = Modifier.width(8.dp))
        Text(text, fontSize = 16.sp)
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun MissingSymptom(text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(Icons.Default.Close, contentDescription = "Missing", tint = Color(0xFFFF6F00))
        Spacer(modifier = Modifier.width(8.dp))
        Text(text, fontSize = 16.sp, color = Color.Gray)
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Preview(showBackground = true)
@Composable
fun PreviewSymptomReportScreen() {
    ReportScreen()
}