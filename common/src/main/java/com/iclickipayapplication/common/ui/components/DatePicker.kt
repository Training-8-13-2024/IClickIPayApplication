package com.iclickipayapplication.common.ui.components

import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.DateRangePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HotelDatePicker(
    dateRangePickerState: DateRangePickerState,
    onDismiss: () -> Unit,
    onConfirm: (
        dateRangePickerState: DateRangePickerState,
    ) -> Unit
) {

    val state = rememberDateRangePickerState()
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,

        )
    val coroutineScope = rememberCoroutineScope()

    ModalBottomSheet(
        onDismissRequest = {
            coroutineScope.launch {
                bottomSheetState.hide()
            }
        },
        sheetState = bottomSheetState,
        scrimColor = Color.Black.copy(alpha = 0.5f),
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp)
                    .background(Color.White)
            ) {
                DateRangePickerSample(state)
            }
            Column {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                ) {
                    CustomButton(
                        text = "Choose dates",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .background(Color(0xFF10C971)),
                        onClick = {
                            coroutineScope.launch {
                                onConfirm(state)
                                bottomSheetState.hide()
                            }
                        }
                    )
                }
//                Button(onClick = {
//                    coroutineScope.launch {
//                        bottomSheetState.show()
//                    }
//                }, modifier = Modifier.padding(16.dp)) {
//                    Text(text = "Open Date Picker")
//                }
//                Text(text = "Start Date:" + if (state.selectedStartDateMillis != null) state.selectedStartDateMillis?.let {
//                    getFormattedDate(
//                        it
//                    )
//                } else "")
//                Text(text = "End Date:" + if (state.selectedEndDateMillis != null) state.selectedEndDateMillis?.let {
//                    getFormattedDate(
//                        it
//                    )
//                } else "")
            }
        }
    }
}

fun getFormattedDate(timeInMillis: Long): String {
    val calender = Calendar.getInstance()
    calender.timeInMillis = timeInMillis
    val dateFormat = SimpleDateFormat("dd/MM/yyyy")
    return dateFormat.format(calender.timeInMillis)
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun DateRangePickerSample(state: DateRangePickerState) {
    DateRangePicker(
        state,
        modifier = Modifier,
        title = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Choose dates",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
        },
        headline = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Box(Modifier.weight(1f)) {
                    (if (state.selectedStartDateMillis != null) state.selectedStartDateMillis?.let {
                        getFormattedDate(
                            it
                        )
                    } else "Check in")?.let {
                        Column(

                        ) {
                            Text(text = it, color = Color(0xFFFF7A1A))
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .background(Color(0xFF10C971), RoundedCornerShape(8.dp))
                ) {
                    Text(text = "to", color = Color.White)
                }
                Box(Modifier.weight(1f)) {
                    (if (state.selectedEndDateMillis != null) state.selectedEndDateMillis?.let {
                        getFormattedDate(
                            it
                        )
                    } else "Check out")?.let {
                        Column(

                        ) {
                            Text(text = it, color = Color(0xFFFF7A1A))
                        }
                    }
                }
//                Box(Modifier.weight(0.2f)) {
//                    Icon(imageVector = Icons.Default.Done, contentDescription = "Okk")
//                }

            }
        },
        showModeToggle = true,
        colors = DatePickerDefaults.colors(
            containerColor = Color.White,
            titleContentColor = Color.Black,
            headlineContentColor = Color.Black,
            weekdayContentColor = Color.Black,
            subheadContentColor = Color.Black,
            yearContentColor = Color.White,
            currentYearContentColor = Color.Red,
            selectedYearContainerColor = Color.Red,
            disabledDayContentColor = Color.Gray,
            todayDateBorderColor = Color(0xFF10C971),
            dayInSelectionRangeContainerColor = Color(0xFF10C971),
            dayInSelectionRangeContentColor = Color.White,
            selectedDayContainerColor = Color(0xFF10C971),
        )
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun PreviewDatePicker() {
    DateRangePickerSample(rememberDateRangePickerState())
//    HotelDatePicker()
}