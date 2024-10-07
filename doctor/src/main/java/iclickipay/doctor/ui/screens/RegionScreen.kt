package iclickipay.doctor.ui.screens

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.iclickipay.doctor.R
import com.iclickipayapplication.common.ui.components.CustomButton
import iclickipay.doctor.ui.DoctorNavigation
import iclickipay.doctor.ui.theme.IClickIPayApplicationDoctorTheme


@Composable
fun RegionScreen(
    doctorNavController: NavHostController? = null
) {

    var selectedRegions by remember { mutableStateOf(listOf<String>()) }

    val regions = listOf(
        "North America", "South America", "North Europe", "Eastern Europe",
        "Central Europe", "Central Africa", "South Africa", "Asia", "Oceania", "North Africa"
    )

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
                    Spacer(modifier = Modifier.size(20.dp))
                    Column {
                        Spacer(modifier = Modifier.padding(10.dp))
                        Text(
                            modifier = Modifier.padding(10.dp),
                            text = "Selection of regions",
                            fontSize = 20.sp
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
                        text = "Select the region you live in and the places where you have traveled\n" +
                                "in the past 12 months.",
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.padding(bottom = 16.dp, top = 10.dp)
                    )
                }

                item{
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(10.dp).fillMaxWidth()) {
                        Image(
                            modifier = Modifier.fillMaxWidth().height(300.dp),
                            painter = painterResource(id = R.drawable.map2),
                            contentDescription = "World Map"
                        )
                    }
                }

                item{
                    regions.chunked(2).forEach { row ->
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                        ) {
                            row.forEach { region ->

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    RegionCheckbox(
                                        region,
                                        selectedRegions.contains(region)
                                    ) { isSelected ->
                                        selectedRegions = if (isSelected) {
                                            selectedRegions + region
                                        } else {
                                            selectedRegions - region
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                item {
                    CustomButton(text = "Next", onClick = {
                        doctorNavController?.navigate(DoctorNavigation.WEEKS.name)
                    })
                }
            }
        }

    }
}

@Composable
fun RegionCheckbox(region: String, isSelected: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier.width(180.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start) {
        Checkbox(
            checked = isSelected,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkedColor = Color(0xFFFF6D00),
                uncheckedColor = Color.LightGray,
            )
        )
        Spacer(modifier = Modifier.width(1.dp))
        Text(text = region, color = Color.Gray)
    }
}

@Composable
@Preview
fun RegionScreenPrev() {
    RegionScreen()
}