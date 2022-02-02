package com.test.composesample.samplebasic

import androidx.compose.foundation.layout.Column
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

class Sample1 {
    @Composable
    fun Greeting(names: List<String>) {
        for (name in names) {
            Text("Hello $name")
        }
    }

    @Composable
    fun TestScreenContents(texts: List<String> = listOf("Welcome", "compose world")) {
        Column {
            texts.forEach {
                Greeting(texts)
                Divider(color = Color.DarkGray)
            }
        }
    }
}