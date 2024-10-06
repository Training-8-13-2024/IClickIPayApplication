package hemanth.doctor.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import hemanth.doctor.ui.screens.AgeScreen
import hemanth.doctor.ui.screens.DoctorGenderScreen
import hemanth.doctor.ui.screens.DoctorScreen1
import hemanth.doctor.ui.screens.DoctorScreen2
import hemanth.doctor.ui.screens.InjuryQuestion1Screen
import hemanth.doctor.ui.screens.InjuryScreen
import hemanth.doctor.ui.screens.QuestionnaireScreen
import hemanth.doctor.ui.screens.RegionScreen
import hemanth.doctor.ui.screens.SymptomsScreen
import hemanth.doctor.ui.screens.WeeksScreen


enum class DoctorNavigation {
    SCREEN1, SCREEN2, WEEKS, QUESTIONNAIRE, SYMPTOMS, GENDER, AGE, REGION, INJURY, INJURYQUESTION1
}

@Composable
fun DoctorScreen(navController: NavHostController? = null) {
    // Create a separate NavController for Doctor navigation
    val doctorNavController = rememberNavController()


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
    }
}


@Preview
@Composable
fun DoctorScreenPreview() {
    DoctorScreen()
}