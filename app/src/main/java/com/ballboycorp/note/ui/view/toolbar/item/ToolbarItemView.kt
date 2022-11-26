package com.ballboycorp.note.ui.view.toolbar.item

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun ToolbarItemView(
    icon: ImageVector,
    onClick: () -> Unit,
) {
    IconButton(
        onClick = onClick
    ) {
        Icon(icon, contentDescription = null, tint = Color.LightGray)
    }
}

@Preview
@Composable
fun ToolbarAddItemView() {
    ToolbarItemView(icon = Icons.Filled.Add) {}
}

@Preview
@Composable
fun ToolbarBookmarkItemView() {
    ToolbarItemView(icon = Icons.Filled.ThumbUp) {}
}