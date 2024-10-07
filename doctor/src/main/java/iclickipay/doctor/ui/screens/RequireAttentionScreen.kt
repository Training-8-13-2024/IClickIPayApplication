package iclickipay.doctor.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.iclickipay.doctor.R
import iclickipay.doctor.ui.parts.CustomTabs
import iclickipay.doctor.ui.parts.TabSymptoms


@Composable
fun RequireAttentionScreen(doctorNavController: NavHostController? = null) {

   val tab1 = TabSymptoms()
    val tab2 = TabSymptoms()
    val tab3 = TabSymptoms()

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
                .background(Color.White)
        )
        {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Spacer(modifier = Modifier.padding(20.dp))
                Box(){
                    Image(
                        painter = painterResource(id = R.drawable.icon_warning),
                        contentDescription = "require_attention"
                    )
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "Requires immediate medical attention",
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = 16.dp, top = 0.dp)
                )
                Spacer(modifier = Modifier.padding(0.dp))
                Text(
                    text = "It is best that you contact a doctor or the nearest emergency department straight away.",
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.LightGray,
                    modifier = Modifier.padding(bottom = 0.dp, top = 0.dp)
                )

                Spacer(modifier = Modifier.padding(10.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    CustomTabs()
                }
            }
        }
    }
}

@Composable
@Preview
fun RequireAttentionScreenPreview() {
    RequireAttentionScreen()
}