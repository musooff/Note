package com.ballboycorp.note.ui.view.screen.folders

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
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
import com.ballboycorp.note.model.Folder
import com.ballboycorp.note.ui.view.Header

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FoldersScreen(
    navController: NavController,
    folders: List<Folder>,
) {
    Column(
        modifier = Modifier
    ) {
        Header(
            text = "folders",
            modifier = Modifier
                .padding(horizontal = 20.dp)
        )
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier,
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(folders) {
                Folder(it) {
                    navController.navigate("notes")
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewFoldersScreen() {
    FoldersScreen(
        navController = rememberNavController(),
        folders = Folder.samples
    )
}

@Composable
private fun Folder(folder: Folder, onClick: () -> Unit) {
    val backgroundShape = RoundedCornerShape(10.dp)
    Row(
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
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = folder.name,
                modifier = Modifier,
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                ),
            )

            Text(
                text = folder.noteCount.toString(),
                modifier = Modifier,
                style = TextStyle(
                    fontSize = 35.sp,
                    fontWeight = FontWeight.ExtraBold
                ),
            )
        }
        Icon(Icons.Filled.ArrowForward, contentDescription = null)
    }
}

@Preview
@Composable
private fun FolderPreview() {
    Folder(Folder.samples.first()) {}
}