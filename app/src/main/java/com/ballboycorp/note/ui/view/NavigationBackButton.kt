package com.ballboycorp.note.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationBackButton(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    Icon(
        imageVector = Icons.Filled.ArrowBack,
        modifier = modifier
            .size(50.dp)
            .clip(CircleShape)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(),
                onClick = { navController.popBackStack() },
            )
            .padding(10.dp),
        contentDescription = null,
    )
}

@Preview
@Composable
private fun Preview() {
    NavigationBackButton(navController = rememberNavController())
}