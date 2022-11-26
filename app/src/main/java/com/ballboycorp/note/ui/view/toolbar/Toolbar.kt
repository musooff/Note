package com.ballboycorp.note.ui.view.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ballboycorp.note.ui.view.toolbar.item.ToolbarItem

@Composable
fun Toolbar(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(20.dp)
    ) {
        LazyRow(
            modifier = Modifier
                .align(Alignment.Center)
                .background(color = Color.DarkGray, shape = RoundedCornerShape(20.dp)),
            contentPadding = PaddingValues(horizontal = 10.dp)
        ) {
            items(ToolbarItem.samples) {
                it.Content {

                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    Toolbar()
}