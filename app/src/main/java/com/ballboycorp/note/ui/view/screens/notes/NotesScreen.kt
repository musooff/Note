package com.ballboycorp.note.ui.view.screens.notes

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ballboycorp.note.model.Note
import com.ballboycorp.note.ui.view.Header
import com.ballboycorp.note.ui.view.NavigationBackButton

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NotesScreen(
    navController: NavController,
    notes: List<Note>,
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
            text = "notes",
            modifier = Modifier
                .padding(horizontal = 20.dp)
        )
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            contentPadding = PaddingValues(20.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(notes) {
                Note(it) {
                    navController.navigate("editor")
                }
            }
        }
    }
}

@Preview
@Composable
private fun NotesScreenPreview() {
    NotesScreen(
        navController = rememberNavController(),
        notes = Note.samples
    )
}

@Composable
private fun Note(note: Note, onClick: () -> Unit) {
    val backgroundShape = RoundedCornerShape(10.dp)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(backgroundShape)
            .background(color = Color.LightGray, shape = backgroundShape)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(),
                onClick = onClick
            )
            .padding(10.dp)
    ) {
        Text(
            text = note.title,
            modifier = Modifier,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            ),
        )

        Text(
            text = note.description,
            modifier = Modifier,
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            ),
        )
    }
}

@Preview
@Composable
private fun NotePreview() {
    Note(Note.samples.first()) {}
}