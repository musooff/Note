package com.ballboycorp.note.ui.view.screen.editor.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleComponentView(
    text: String,
) {
    var value by remember { mutableStateOf(text) }
    BasicTextField(
        value = value,
        onValueChange = {
            value = it
        },
        modifier = Modifier
            .padding(horizontal = 20.dp),
        textStyle = TextStyle(
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
    )
}

@Preview
@Composable
private fun Preview() {
    TitleComponentView(text = LoremIpsum(3).values.first())
}