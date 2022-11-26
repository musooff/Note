package com.ballboycorp.note.ui.view.screen.editor

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ballboycorp.note.model.Note
import com.ballboycorp.note.ui.view.Header
import com.ballboycorp.note.ui.view.NavigationBackButton
import com.ballboycorp.note.ui.view.screen.editor.component.TextComponentView
import com.ballboycorp.note.ui.view.screen.editor.component.TitleComponentView
import com.ballboycorp.note.ui.view.toolbar.Toolbar

@Composable
fun EditorScreen(
    navController: NavController,
    note: Note = Note.samples.first(),
) {
    Box(modifier = Modifier.fillMaxSize()) {
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
            LazyColumn(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                repeat(3) {
                    item {
                        TitleComponentView(
                            text = LoremIpsum(3).values.first()
                        )
                    }
                    item {
                        TextComponentView(
                            text = LoremIpsum(10).values.first()
                        )
                    }
                }
            }
        }
        Toolbar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
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