package iclickipay.doctor.ui.parts

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.iclickipay.doctor.R
import iclickipay.doctor.ui.components.CustomProgressIndicator


@Composable
fun TabSummary() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
            .background(color = Color.White),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {


        Column(
            modifier = Modifier
                .padding(25.dp)
                .background(color = Color.White)
        ) {
            Text(text = "Summary")
            Spacer(modifier = Modifier.padding(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = " Your answer"
                )
                Icon(
                    Icons.Default.KeyboardArrowRight,
                    contentDescription = "Arrow Right",
                    tint = Color.Gray
                )
            }
            Spacer(modifier = Modifier.padding(10.dp))
            HorizontalDivider(modifier = Modifier.fillMaxWidth())
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = " Your answer",
                    color = Color.Gray
                )
               Text(
                     text = "15",
               )
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "Interview duration",
                    color = Color.Gray
                )
                Text(
                    text = "15 min",
                )
            }

        }
    }
}


//@Composable
//fun ResultsList(navController: NavController?=null) {
//    Column {
//        // Polytrauma item
//        ResultItem(
//            label = "Polytrauma",
//            color = Color.Green,
//            onClick = {
//
//            }
//        )
//
//        Divider()
//
//        // Tension headaches item
//        ResultItem(
//            label = "Tension headaches",
//            color = Color(0xFFFF6F00),
//            onClick = {
//
//            }
//        )
//
//        Divider()
//
//        // Neck sprain item
//        ResultItem(
//            label = "Neck sprain",
//            color = Color.Red,
//            onClick = {
//
//            }
//        )
//    }
//}

//
//@Composable
//fun ResultItem(label: String, color: Color, onClick: () -> Unit) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(6.dp, vertical = 20.dp),
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Start
//        ) {
//            Box(
//                modifier = Modifier
//                    .padding(end = 0.dp),
//                contentAlignment = Alignment.Center,
//            ) {
//
//                CustomProgressIndicator(
//                    progress = 0.6f,
//                    fillColor = color,
//                    backgroundColor = Color.LightGray
//                )
//            }
//
//            Spacer(modifier = Modifier.width(20.dp))
//
//            Text(
//                text = AnnotatedString(label),
//                modifier = Modifier,
//                style = LocalTextStyle.current.copy(fontSize = 18.sp)
//            )
//        }
//        Box(modifier = Modifier){
//            Icon( painter = painterResource(id = R.drawable.icon_keyboard_right), contentDescription = "keyboard_arrow_right" )
//        }
//    }
//}


@Composable
@Preview
fun TabSummatuPreview() {
    TabSummary()
}