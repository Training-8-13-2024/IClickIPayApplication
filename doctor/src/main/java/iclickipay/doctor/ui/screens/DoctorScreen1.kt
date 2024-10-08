package iclickipay.doctor.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.iclickipay.data.doctor.local.entities.PatientData
import com.iclickipay.doctor.R
import com.iclickipayapplication.common.ui.components.CustomButton
import iclickipay.doctor.ui.DoctorNavigation
import iclickipay.doctor.viewmodel.PatientViewModel


@Composable
fun DoctorScreen1(
    navController: NavHostController? = null,
    viewModel: PatientViewModel = hiltViewModel()
) {

        viewModel.insertPatient(PatientData(
            id = 1,
            age = 30,
            gender = 0,
            option = 0,
            item = "item",
            injury = "injury",
            severity = 3,
            symptoms = "symptoms",
        ))

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
                        .padding(0.dp)
                        .height(55.dp)
                        .padding(10.dp)
                        .clickable { navController?.popBackStack() },
                    painter = painterResource(id = R.drawable.back_arrow), contentDescription = "Back")
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding))
        {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.padding(30.dp))
                Image(
                    painter = painterResource(id = R.drawable.doctor_screen1),
                    contentDescription = "Doctor Screen"
                )
                Spacer(modifier = Modifier.padding(30.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Text(
                        text = "Health",
                        style = androidx.compose.ui.text.TextStyle(fontSize = 40.sp)
                    )
                    Spacer(modifier = Modifier.padding(30.dp))
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis lobortis sit amet odio in egestas. Pellen tesque ultricies justo.",
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.padding(30.dp))

                CustomButton(
                    text = "Let's go",
                    onClick = {
                        navController?.navigate(DoctorNavigation.SCREEN2.name)
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.padding(10.dp))
            }
        }
    }
}

@Composable
@Preview
fun DoctorScreen1Preview() {
    DoctorScreen1()
}