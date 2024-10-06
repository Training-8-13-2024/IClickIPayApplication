package com.iclickipayapplication.common.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.compose.ui.zIndex


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchField(
    onQueryChange: (String) -> Unit,
    onClear: () -> Unit,
    query: String,
    onSuggestionSelected: (String) -> Unit = {},
    suggestions: List<String> = emptyList(),
) {
    var selectedText by remember { mutableStateOf(query) }

    // To manage the keyboard and focus manually
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    var category by remember {
        mutableStateOf("")
    }

    val heightTextFields by remember {
        mutableStateOf(55.dp)
    }

    var textFieldSize by remember {
        mutableStateOf(Size.Zero)
    }

    var expanded by remember {
        mutableStateOf(false)
    }
    val interactionSource = remember {
        MutableInteractionSource()
    }

    // Category Field
    Column(
        modifier = Modifier
            .padding(30.dp)
            .fillMaxWidth()
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    expanded = false
                }
            )
    ) {


        Column(modifier = Modifier.fillMaxWidth()
            .shadow(
                elevation = 1.dp,
                spotColor = Color.White,
                shape = RoundedCornerShape(5.dp)
            )) {

            Row(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(heightTextFields)
//                        .border(
//                            width = 1.8.dp,
//                            color = Color.Black,
//                            shape = RoundedCornerShape(15.dp)
//                        )
                        .onGloballyPositioned { coordinates ->
                            textFieldSize = coordinates.size.toSize()
                        }
                        .focusRequester(focusRequester),
                    value = category,
                    onValueChange = {
                        category = it
                        expanded = true
                        if (category.isNotEmpty()) {
                            focusRequester.requestFocus()  // Keep the focus on the TextField
                            keyboardController?.show()     // Make sure the keyboard stays visible
                        }
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            expanded = false
                            keyboardController?.hide()
                        }
                    ),
                    placeholder = {
                        Text(
                            text = "Search",
                            fontSize = 16.sp,
                        )
                    },
                    singleLine = true,
                    trailingIcon = {
                        IconButton(onClick = { expanded = !expanded }) {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                imageVector = Icons.Rounded.Search,
                                contentDescription = "arrow",
                                tint = Color.Black
                            )
                        }
                    }
                )


                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
                        .zIndex(1f)  // Make sure dropdown appears on top
                ) {
                    val filteredCategories = if (category.isNotEmpty()) {
                        suggestions.filter {
                            it.contains(category, ignoreCase = true)
                        }
                    } else suggestions

                    filteredCategories.forEach { selectedCategory ->
                        DropdownMenuItem(
                            text = { Text(selectedCategory) },
                            onClick = {
                                category = selectedCategory
                                expanded = false
                                keyboardController?.hide()
                            }
                        )
                    }
                }
            }
        }
    }


    /*
//    {
//
//    OutlinedTextField(
//        textStyle = androidx.compose.ui.text.TextStyle(fontSize = 16.sp),
//        value = query,
//        onValueChange = onQueryChange,
//        placeholder = { Text(text = "Search") },
//        trailingIcon = {
//            Icon(
//                imageVector = Icons.Default.Search,
//                contentDescription = "Search Icon"
//            )
//        },
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(12.dp)
//            .shadow(elevation = 4.dp)
//            .height(56.dp),
//        shape = RoundedCornerShape(8.dp),
//        colors = TextFieldDefaults.colors(
//            contentColorFor(backgroundColor = Color(0xFFFF7A1A),
//                )
//        ),
//        keyboardOptions = KeyboardOptions.Default.copy(
//            imeAction = ImeAction.Search
//        ),
//        keyboardActions = KeyboardActions(onSearch = { expanded = false })
//    )
//    ExposedDropdownMenu(
//        expanded = expanded,
//        onDismissRequest = { expanded = false }
//    ) {
//        suggestions.filter {
//            it.contains(query, ignoreCase = true)
//        }.forEach { suggestion ->
//            DropdownMenuItem(
//                text = { Text(suggestion) },
//                onClick = {
//                    selectedText = suggestion
//                    onSuggestionSelected(suggestion)
//                    expanded = false
//                },
//                modifier = Modifier.fillMaxWidth()
//            )
//        }
//    }
//}*/
}


@Composable
fun CategoryItems(
    title: String,
    onSelect: (String) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onSelect(title)
            }
            .padding(10.dp)
    ) {
        Text(text = title, fontSize = 16.sp)
    }

}
@Composable
@Preview
fun CustomSearchFieldPreview() {
    Scaffold {im ->
        Box(
            modifier = Modifier.fillMaxWidth().padding(im)
        ){
        CustomSearchField(

            onQueryChange = {},
            onClear = {},
            query = "",
        )
    }}

}