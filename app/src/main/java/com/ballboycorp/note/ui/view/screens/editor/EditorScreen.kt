package com.ballboycorp.note.ui.view.screens.editor

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ballboycorp.note.model.Note
import com.ballboycorp.note.ui.view.Header
import com.ballboycorp.note.ui.view.NavigationBackButton

@Composable
fun EditorScreen(
    navController: NavController,
    note: Note = Note.samples.first(),
) {
    Column(
        modifier = Modifier
    ) {
        NavigationBackButton(
            navController = navController,
            modifier = Modifier
                .padding(start = 10.dp)
        )
        Header(
            text = note.title,
            modifier = Modifier
                .padding(horizontal = 20.dp)
        )
    }
}

@Preview
@Composable
private fun EditorScreenPreview() {
    EditorScreen(
        navController = rememberNavController(),
    )
}