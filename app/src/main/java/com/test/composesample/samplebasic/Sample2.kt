package com.test.composesample.samplebasic

import android.R
import android.content.Context
import android.content.res.Resources
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


class Sample2 {
    @Composable
    fun ClickCounter(clicks: Int, onClick: () -> Unit) {
        Button(onClick = onClick, Modifier.padding(10.dp)) {
            Text("I've been clicked $clicks times")

        }
    }

    @Composable
    fun TestClickCounter(buttonNum: Int, context: Context)
    {
        Column {
            for (i in 0..buttonNum)
//                Column {
                ClickCounter(clicks = i) {
                    Toast.makeText(context, "hi toast $i", Toast.LENGTH_SHORT).show()
                }
                Divider(color = Color.DarkGray)
//                }
            }
    }


}