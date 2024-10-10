package iclickipay.doctor.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.iclickipay.doctor.R
import iclickipay.doctor.ui.DoctorNavigation

@Composable
fun InjuryScreen(doctorNavController: NavHostController? = null) {
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
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .padding(horizontal = 16.dp, vertical = 20.dp),
                    verticalArrangement = Arrangement.Center
                )
                {
                Text(
                    text = "Was your injury caused by force majeure such as a car accident or fall, or did you develop serious symptoms as a result of the accident, such as difficulty in breathing, heavy bleeding, difficulty moving arms or legs or double vision?",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    lineHeight = 44.sp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                }

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                ) {
                    ResponseButton(
                        text = "Yes",
                        backgroundColor = Color(0xFF4CAF50),
                        icon = Icons.Default.Check,
                        onClick = {
                            doctorNavController?.navigate(DoctorNavigation.INJURYQUESTION1.name)
                        },
                        modifier = Modifier
                            .height(94.dp)
                            .width(94.dp)
                            .padding(horizontal = 4.dp)
                    )
                    ResponseButton(
                        text = "No",
                        backgroundColor = Color(0xFFFF5722),
                        icon = Icons.Default.Close,
                        onClick = {
                            doctorNavController?.navigate(DoctorNavigation.INJURYQUESTION1.name)
                        },
                        modifier = Modifier
                            .height(94.dp)
                            .width(94.dp)
                            .padding(horizontal = 4.dp)
                    )
                    ResponseButton(
                        modifier = Modifier
                            .height(94.dp)
                            .width(94.dp)
                            .padding(horizontal = 4.dp),
                        text = "Pass",
                        backgroundColor = Color(0xFFE0E0E0),
                        icon = Icons.Default.ArrowForward,
                        onClick = {
                            doctorNavController?.navigate(DoctorNavigation.INJURYQUESTION1.name)
                        }
                    )
                }
            }
        }
    )
}

@Composable
fun ResponseButton(
    text: String,
    backgroundColor: Color,
    icon: ImageVector? = null,
    onClick: () -> Unit,
    modifier: Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Spacer(modifier = Modifier.width(28.dp))
            if (icon != null) {
                Icon(imageVector = icon, contentDescription = text)
            }
            Spacer(modifier = Modifier.width(28.dp))
            Text(
                textAlign = TextAlign.Center,
                text = text,
                color = if (backgroundColor == Color(0xFFE0E0E0)) Color.Black else Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InjuryScreenPreview() {
    InjuryScreen()
}