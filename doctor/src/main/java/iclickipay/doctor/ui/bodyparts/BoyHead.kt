package iclickipay.doctor.ui.bodyparts

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontVariation.weight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iclickipay.doctor.R
import iclickipay.doctor.ui.screens.HeadPart


@Composable
fun BoyHead(selectedPartsOfHead: MutableState<Set<String>> = remember { mutableStateOf(setOf()) }) {

    val rows = 6
    val columns = 5
    val headImage = remember {
        mutableStateOf(R.drawable.face_boy_parts_clean)
    }

    // Variable to track the click location or response
    var clickLocation by remember { mutableStateOf("No Click Yet") }

    val selectedParts = getSelectedParts(selectedPartsOfHead.value.toList())

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp)
                ,
            painter = painterResource(id = getSelectedParts(selectedPartsOfHead.value.toList())),
            contentDescription = "Body-Head"
        )

    Column(modifier = Modifier.fillMaxWidth()) {
        for (row in 0 until rows) {
            Row(modifier = Modifier.fillMaxWidth()) {
                for (column in 0 until columns) {
                    val index = row * columns + column
                    Box(
                        modifier = if(
                            index in 6..8 || index in 11..13
                        ){
                            Modifier
                                .width(50.dp)
                                .height(80.dp)
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = null,
                                ){
                                    selectedPartsOfHead.value = selectedPartsOfHead.value.toMutableSet().apply {
                                        if(contains(HeadPart.FOREHEAD.name)){
                                            remove(HeadPart.FOREHEAD.name)
                                        }else{
                                            add(HeadPart.FOREHEAD.name)
                                        }
                                    }
                                }
                                .weight(1f)
                                .aspectRatio(1f)
                                .padding(0.dp)

                        }else if(
                            index == 17
                        ){
                            Modifier
                                .width(50.dp)
                                .height(80.dp)
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = null,
                                ){
                                    selectedPartsOfHead.value = selectedPartsOfHead.value.toMutableSet().apply {
                                        if(contains(HeadPart.NOSE.name)){
                                            remove(HeadPart.NOSE.name)
                                        }else{
                                            add(HeadPart.NOSE.name)
                                        }
                                    }
                                }
                                .weight(1f)
                                .aspectRatio(1f)
                                .padding(0.dp)
                        }else if(
                            index == 27
                        ){
                            Modifier
                                .width(50.dp)
                                .height(80.dp)
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = null,
                                    onClick =
                                {
                                    selectedPartsOfHead.value = selectedPartsOfHead.value.toMutableSet().apply {
                                        if(contains(HeadPart.CHIN.name)){
                                            remove(HeadPart.CHIN.name)
                                        }else{
                                            add(HeadPart.CHIN.name)
                                        }
                                    }
                                },
                                    )
                                .weight(1f)
                                .aspectRatio(1f)
                                .padding(0.dp)
                        }

                        else
                        {
                            Modifier
                                .width(50.dp)
                                .height(80.dp)
                                .weight(1f)
                                .aspectRatio(1f)
                                .padding(0.dp)
                        }

                        ,contentAlignment = androidx.compose.ui.Alignment.Center
                    ) {
                        // The content for each grid item
                        Text( text = "${row * columns + column}", color = Color.Transparent)
                    }
                }
            }
        }
    }
}
}


fun getSelectedParts(list: List<String>): Int
{
//    list can have the following parts: Fore head, Chin, Nose return a proper drawable based on the selected parts there can be combinations of the parts
    var selectedParts = 0
    if (list.contains(HeadPart.FOREHEAD.name) && list.contains(HeadPart.CHIN.name) && list.contains(HeadPart.NOSE.name)) {
        return R.drawable.face_boy_forehead_nose_chin
    }
    else if (list.contains(HeadPart.FOREHEAD.name) && list.contains(HeadPart.CHIN.name)) {
        return R.drawable.face_boy_forehead_chin
    }
    else if (list.contains(HeadPart.FOREHEAD.name) && list.contains(HeadPart.NOSE.name)) {
        return R.drawable.face_boy_nose_forehead
    }
    else if (list.contains(HeadPart.CHIN.name) && list.contains(HeadPart.NOSE.name)) {
        return R.drawable.face_boy_nose_chin
    }
    else if (list.contains(HeadPart.FOREHEAD.name)) {
        return R.drawable.face_forehead
    }
    else if (list.contains(HeadPart.CHIN.name)) {
        return R.drawable.face_boy_chin
    }
    else if (list.contains(HeadPart.NOSE.name)) {
        return R.drawable.face_boy_nose
    }
    else return R.drawable.face_boy_parts_clean
}

@Composable
@Preview
fun BoyHeadPreview() {
    BoyHead()
}