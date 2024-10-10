package iclickipay.doctor.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.iclickipay.data.doctor.models.Patient
import com.iclickipay.data.doctor.models.toPatientData
import com.iclickipay.doctor.R
import dagger.hilt.android.lifecycle.HiltViewModel
import iclickipay.doctor.ui.DoctorNavigation
import iclickipay.doctor.viewmodel.PatientViewModel


@Composable
fun DoctorGenderScreen(
    doctorNavController: NavHostController? = null,
    viewModel: PatientViewModel = hiltViewModel()
) {


    val patient = Patient()
//    log patient data from viewmodel
//    val patient by viewModel._patientTemp.value
    Log.e("DoctorGenderScreen", "Patient: $patient")
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp, horizontal = 10.dp),
                horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(35.dp)
                        .clickable {

                        }
                        .padding(0.dp),
                    painter = painterResource(id = R.drawable.home_icon),
                    contentDescription = "Back"
                )
                Row {
                    Image(
                        modifier = Modifier
                            .size(35.dp)
                            .padding(0.dp),
                        painter = painterResource(id = R.drawable.options_icon),
                        contentDescription = "Back"
                    )
                    Image(
                        modifier = Modifier
                            .size(35.dp)
                            .padding(0.dp),
                        painter = painterResource(id = R.drawable.pin_icon),
                        contentDescription = "Back"
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
        {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    modifier = Modifier.padding(20.dp),
                    text = "Select your Gender",
                    fontSize = 25.sp
                )


                Spacer(modifier = Modifier.padding(50.dp))
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Card(
                            onClick = {
                                patient.gender = 0
                                patient.id = 1
                                viewModel.updatePatient(patient.toPatientData())
                                doctorNavController?.navigate(DoctorNavigation.AGE.name)
                            },
                            shape = RoundedCornerShape(6.dp),
                            elevation = CardDefaults.cardElevation(2.dp),
                            modifier = Modifier
                                .width(170.dp)
                                .height(240.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White,
                            )
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.gender_female),
                                    contentDescription = "female"
                                )
                                Spacer(modifier = Modifier.padding(10.dp))
                                Text(
                                    text = "Female",
                                    fontSize = 20.sp
                                )
                            }
                        }
                        Spacer(modifier = Modifier.padding(10.dp))
                        Card(
                            onClick = {
                                patient.gender = 1
                                patient.id = 1
                                viewModel.updatePatient(patient.toPatientData())
                                doctorNavController?.navigate(DoctorNavigation.AGE.name)
                            },
                            shape = RoundedCornerShape(6.dp),
                            elevation = CardDefaults.cardElevation(2.dp),
                            modifier = Modifier
                                .width(170.dp)
                                .height(240.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White,
                            )
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.gender_male),
                                    contentDescription = "Male"
                                )
                                Spacer(modifier = Modifier.padding(10.dp))
                                Text(
                                    text = "Male",
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun DoctorGenderScreenPreview() {
    DoctorGenderScreen()
}