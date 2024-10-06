package hemanth.doctor.ui.bodyparts

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iclickipay.doctor.R
import hemanth.doctor.ui.screens.HeadPart


@Composable
fun BoyHead(selectedPartsOfHead: MutableState<Set<String>> = remember { mutableStateOf(setOf()) }) {

    val headImage = remember {
        mutableStateOf(R.drawable.face_boy_parts_clean)
    }

    // Variable to track the click location or response
    var clickLocation by remember { mutableStateOf("No Click Yet") }

    val selectedParts = getSelectedParts(selectedPartsOfHead.value.toList())

    Row {
        Image(
            modifier = Modifier
                .height(500.dp)
                .width(100.dp)
                .weight(1f)
                .pointerInput(Unit) {
                    detectTapGestures { offset ->
                        val x = offset.x
                        val y = offset.y
                        Log.i("Click Location", "X: $x, Y: $y")
                        when {
                            x > 100 && x < 500 && y < 390 && y > 280 -> {
                                Log.i("Click Location", "Fore head!")
                                if (selectedPartsOfHead.value.contains(HeadPart.FOREHEAD.name)) {
                                    selectedPartsOfHead.value -= HeadPart.FOREHEAD.name
                                } else {
                                    selectedPartsOfHead.value += HeadPart.FOREHEAD.name
                                }
                            }

                            x > 310 && x < 370 && y < 870 && y > 840 -> {
                                Log.i("Click Location", "Chin!")
                                if (selectedPartsOfHead.value.contains(HeadPart.CHIN.name)) {
                                    selectedPartsOfHead.value -= HeadPart.CHIN.name
                                } else {
                                    selectedPartsOfHead.value += HeadPart.CHIN.name
                                }
                            }

                            x > 340 && x < 380 && y < 625 && y > 580 -> {
                                Log.i("Click Location", "Nose!")
//                                check if the part is already selected
                                if (selectedPartsOfHead.value.contains(HeadPart.NOSE.name)) {
                                    selectedPartsOfHead.value -= HeadPart.NOSE.name
                                } else {
                                    selectedPartsOfHead.value += HeadPart.NOSE.name
                                }
                            }

                            else -> {

                            }
                        }
                    }
                },
            painter = painterResource(id = getSelectedParts(selectedPartsOfHead.value.toList())),
            contentDescription = "Body-Head"
        )
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
//    BoyHead(selectedPartsOfHead)
}