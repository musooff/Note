package com.ballboycorp.note.ui.view.screen.editor.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextComponentView(
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
            fontSize = 20.sp
        )
    )
}

@Preview
@Composable
private fun Preview() {
    TextComponentView(text = LoremIpsum(100).values.first())
}