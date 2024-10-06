package hemanth.doctor.ui.screens

import android.app.Activity
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.iclickipay.doctor.R
import com.iclickipayapplication.common.ui.components.CustomButton
import com.iclickipayapplication.common.ui.components.CustomSearchField
import hemanth.doctor.ui.DoctorNavigation
import hemanth.doctor.ui.bodyparts.BoyBack
import hemanth.doctor.ui.bodyparts.BoyFront
import hemanth.doctor.ui.bodyparts.BoyHead
import hemanth.doctor.ui.components.InputChipExample

enum class BodyPart {
    HEAD, BODY
}
enum class HeadPart {
    FOREHEAD, CHIN, NOSE
}

@Composable
fun SymptomsScreen(doctorNavController: NavHostController? = null) {

    val context = LocalContext.current as Activity
//    log the current route

    val suggestions = listOf(
        "Headache", "Headache generalized", "Headache on one side",
        "Headache strong", "Headache weak"
    )

    val selectedPartsOfHead = remember {
        mutableStateOf(setOf<String>())
    }

    Log.i(
        "SymptomsScreen",
        "Current route: ${doctorNavController?.currentBackStackEntry?.destination?.route}"
    )
    val query = remember {
        mutableStateOf("")
    }
    val bodySide = remember {
        mutableStateOf("front")
    }
    val bodyOrHead = remember {
        mutableStateOf("body")
    }

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
                        text = "Add your symptoms",
                        fontSize = 20.sp
                    )
                }
            }
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 75.dp)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                CustomSearchField(
                    suggestions = suggestions,
                    onQueryChange = {
                        query.value = it
                    },
                    onClear = {
                        query.value = ""
                    },
                    query = query.value,
                    onSuggestionSelected = {
                        Toast.makeText(context, "Selected: $it", Toast.LENGTH_SHORT).show()
                    }
                )


                Spacer(modifier = Modifier.size(10.dp))

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceEvenly
                ) {
                    items(selectedPartsOfHead.value.toList()) {
                        InputChipExample(
                            text = it,
                            onDismiss = {
                                selectedPartsOfHead.value -= it
                            }
                        )
                    }
                }

                when (bodyOrHead.value) {
                    "body" -> {
                        when (bodySide.value) {
                            "front" -> {
                                BoyFront()
                            }

                            "back" -> {
                                BoyBack()
                            }
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp, vertical = 100.dp),
                            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceAround,
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Spacer(modifier = Modifier.padding(10.dp))
                            IconButton(onClick = {
                                if (bodySide.value == "front") {
                                    bodySide.value = "back"
                                } else {
                                    bodySide.value = "front"
                                }
                            }) {
                                Surface(
                                    modifier = Modifier.size(65.dp),
                                    shape = CircleShape,
                                    color = Color(0xFF10C971),
                                    shadowElevation = 3.dp
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Image(
                                            painter = painterResource(id = R.drawable.icon_turn),
                                            contentDescription = "turn"
                                        )
                                    }
                                }
                            }


                            IconButton(onClick = {
                                if (bodyOrHead.value == "body") {
                                    bodyOrHead.value = "head"
                                } else {
                                    bodyOrHead.value = "body"
                                }
                            }) {
                                Surface(
                                    modifier = Modifier.size(65.dp),
                                    shape = CircleShape,
                                    color = Color(0xFFFF7A1A),
                                    shadowElevation = 3.dp
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Image(
                                            painter = painterResource(id = R.drawable.icon_head),
                                            contentDescription = "head"
                                        )
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.padding(10.dp))
                        }
                    }

                    "head" -> {

                        BoyHead(selectedPartsOfHead = selectedPartsOfHead)

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp, vertical = 100.dp),
                            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceAround,
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Spacer(modifier = Modifier.padding(10.dp))
                            IconButton(onClick = {
                                if (bodySide.value == "front") {
                                    bodySide.value = "back"
                                } else {
                                    bodySide.value = "front"
                                }
                            }) {
                                Surface(
                                    modifier = Modifier.size(65.dp),
                                    shape = CircleShape,
                                    color = Color(0xFFF5F5F5),
                                    shadowElevation = 3.dp
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Image(
                                            painter = painterResource(id = R.drawable.icon_body),
                                            contentDescription = "turn"
                                        )
                                    }
                                }
                            }


                            IconButton(onClick = {
                                if (bodyOrHead.value == "body") {
                                    bodyOrHead.value = "head"
                                } else {
                                    bodyOrHead.value = "body"
                                }
                            }) {
                                Surface(
                                    modifier = Modifier.size(60.dp),
                                    shape = CircleShape,
                                    border = BorderStroke(1.dp, Color.DarkGray),
                                    color = Color.White,
                                    shadowElevation = 3.dp
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Image(
                                            painter = painterResource(id = R.drawable.icon_head_selected),
                                            contentDescription = "head"
                                        )
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.padding(10.dp))
                        }
                    }
                }
                Box(modifier = Modifier.fillMaxWidth().padding(bottom = 70.dp, start = 20.dp, end = 20.dp)) {
                    CustomButton(text = "Next", onClick = {
                        doctorNavController?.navigate(DoctorNavigation.REGION.name)
                    })
                }
            }
        }
        Spacer(modifier = Modifier.padding(innerPadding))
    }
}


//extend Color and add a new color
val Color0x10C971 = Color(0x10C971)
fun Color.MyGreen() = Color(0x10C971)








@Composable
@Preview
fun SymptomsScreenPreview() {
    SymptomsScreen()
}

// In the above code, we have created a  SymptomsScreen  composable function that takes a  NavHostController  as a parameter. We have used the  CustomSearchField  composable function to display the search field. We have also used the  Image  composable function to display the images.
// Step 4: Create a composable function for the CustomSearchField
// Create a new Kotlin file named  CustomSearchField.kt  inside the  components  package and add the following code.