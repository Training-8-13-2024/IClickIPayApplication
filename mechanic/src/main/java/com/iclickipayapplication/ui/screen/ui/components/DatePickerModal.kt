package com.iclickipayapplication.ui.screen.ui.components

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModal(
    onDismiss: () -> Unit,
    state: DatePickerState,
) {
    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
    ) {
        DatePicker(state = state)
    }
}
