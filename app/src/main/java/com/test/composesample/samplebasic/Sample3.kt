package com.test.composesample.samplebasic

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


class Sample3 {
    @Composable fun TestScreenContents(texts: List<String> = listOf("Welcome", "compose world")) {
        Column {
            texts.forEach {
                Greeting(it)
                Divider(color = Color.DarkGray)
            }
            CounterButton()
        }
    }

    @Composable fun CounterButton() {
        Column {
            val count = remember { mutableStateOf(0) }
            Button(onClick = { count.value++ }, Modifier.padding(20.dp)) {
                Text("Clicked Count: ${count.value}")
            }

            var countNoRemember = 0
            Button(onClick = { countNoRemember++ }) {
                Text("Clicked countNoRemember: ${countNoRemember}")
            }
        }
    }

    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }
}