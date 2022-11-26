package com.ballboycorp.note

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ballboycorp.note.model.Folder
import com.ballboycorp.note.model.Note
import com.ballboycorp.note.ui.theme.NoteTheme
import com.ballboycorp.note.ui.view.screen.editor.EditorScreen
import com.ballboycorp.note.ui.view.screen.folders.FoldersScreen
import com.ballboycorp.note.ui.view.screen.notes.NotesScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 20.dp),
                    color = MaterialTheme.colors.background
                ) {

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "folders") {
                        composable("folders") {
                            FoldersScreen(
                                navController = navController,
                                folders = Folder.samples
                            )
                        }
                        composable("notes") {
                            NotesScreen(
                                navController = navController,
                                notes = Note.samples
                            )
                        }
                        composable("editor") {
                            EditorScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}