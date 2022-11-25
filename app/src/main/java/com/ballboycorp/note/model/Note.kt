package com.ballboycorp.note.model

import androidx.compose.runtime.Immutable
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import kotlin.random.Random

@Immutable
data class Note(
    val title: String,
    val description: String,
) {
    companion object {
        private val random = Random(100)
        val samples = buildList {
            repeat(20) {
                add(
                    Note(
                        title = LoremIpsum(random.nextInt(1, 4)).values.first(),
                        description = LoremIpsum(random.nextInt(1, 10)).values.first(),
                    )
                )
            }
        }
    }
}
