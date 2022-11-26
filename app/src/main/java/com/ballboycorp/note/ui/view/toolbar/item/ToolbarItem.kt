package com.ballboycorp.note.ui.view.toolbar.item

import androidx.annotation.DrawableRes
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.ballboycorp.note.R

data class ToolbarItem(
    @DrawableRes val icon: Int
) {
    @Composable
    fun Content(onClick: () -> Unit) {
        IconButton(
            onClick = onClick,
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = Color.LightGray
            )
        }
    }

    companion object {
        val samples = listOf(
            ToolbarItem(R.drawable.toolbar_item_add),
            ToolbarItem(R.drawable.toolbar_item_bookmark),
            ToolbarItem(R.drawable.toolbar_item_bold),
            ToolbarItem(R.drawable.toolbar_item_italic),
            ToolbarItem(R.drawable.toolbar_item_strikethrough),
            ToolbarItem(R.drawable.toolbar_item_underline),
        )
    }
}