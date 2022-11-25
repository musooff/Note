package com.ballboycorp.note.model

import androidx.compose.runtime.Immutable
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import kotlin.random.Random

@Immutable
data class Folder(
    val name: String,
    val noteCount: Int,
) {
    companion object {
        private val random = Random(100)
        val samples = buildList {
            repeat(20) {
                add(Folder(name = LoremIpsum(random.nextInt(1, 4)).values.first(), noteCount = random.nextInt(1, 100)))
            }
        }
    }
}
