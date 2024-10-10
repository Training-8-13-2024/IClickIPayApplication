package iclickipay.doctor.ui

import MapScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import iclickipay.doctor.ui.screens.AgeScreen
import iclickipay.doctor.ui.screens.DoctorGenderScreen
import iclickipay.doctor.ui.screens.DoctorScreen1
import iclickipay.doctor.ui.screens.DoctorScreen2
import iclickipay.doctor.ui.screens.InjuryQuestion1Screen
import iclickipay.doctor.ui.screens.InjuryQuestion2Screen
import iclickipay.doctor.ui.screens.InjuryScreen
import iclickipay.doctor.ui.screens.QuestionnaireScreen
import iclickipay.doctor.ui.screens.RegionScreen
import iclickipay.doctor.ui.screens.ReportScreen
import iclickipay.doctor.ui.screens.RequireAttentionScreen
import iclickipay.doctor.ui.screens.SymptomsScreen
import iclickipay.doctor.ui.screens.WeeksScreen


enum class DoctorNavigation {
    SCREEN1, SCREEN2, WEEKS, QUESTIONNAIRE, SYMPTOMS, GENDER, AGE, REGION, INJURY, INJURYQUESTION1, INJURYQUESTION2, REQUIREATTENTION, MAP, REPORT
}

@Composable
fun DoctorScreen(navController: NavHostController? = null) {
    // Create a separate NavController for Doctor navigation
    val doctorNavController = rememberNavController()

//    create a function to navigate to teh home screen on navController
    fun navigateToHome() {
        navController?.navigate("HOME")
    }

    NavHost(
        navController = doctorNavController,
        startDestination = DoctorNavigation.SCREEN1.name
    ) {
        composable(
            DoctorNavigation.SCREEN1.name,
        ) {
            DoctorScreen1(doctorNavController)
        }
        composable(DoctorNavigation.SCREEN2.name) {
            DoctorScreen2(doctorNavController)
        }
        composable(
            DoctorNavigation.GENDER.name,
        ) {
            DoctorGenderScreen(doctorNavController)
        }
        composable(
            DoctorNavigation.AGE.name,
        ) {
            AgeScreen(doctorNavController)
        }
        composable(
            DoctorNavigation.QUESTIONNAIRE.name,
        ) {
            QuestionnaireScreen(doctorNavController)
        }
        composable(
            DoctorNavigation.SYMPTOMS.name,
        )
        {
            SymptomsScreen(doctorNavController)
        }
        composable(
            DoctorNavigation.REGION.name,
        )
        {
            RegionScreen(doctorNavController)
        }
        composable(
            DoctorNavigation.WEEKS.name,
        )
        {
            WeeksScreen(doctorNavController)
        }
        composable(
            DoctorNavigation.INJURY.name,
        )
        {
            InjuryScreen(doctorNavController)
        }
        composable(
            DoctorNavigation.INJURYQUESTION1.name,
        )
        {
            InjuryQuestion1Screen(doctorNavController)
        }
        composable(
            DoctorNavigation.INJURYQUESTION2.name,
        )
        {
            InjuryQuestion2Screen(doctorNavController)
        }
        composable(
            DoctorNavigation.REQUIREATTENTION.name,
        )
        {
            RequireAttentionScreen(doctorNavController)
        }
        composable(
            DoctorNavigation.MAP.name,
        )
        {
            MapScreen(doctorNavController)
        }
        composable(
            DoctorNavigation.REPORT.name,
        )
        {
            ReportScreen(doctorNavController)
        }
    }
}


@Preview
@Composable
fun DoctorScreenPreview() {
    DoctorScreen()
}