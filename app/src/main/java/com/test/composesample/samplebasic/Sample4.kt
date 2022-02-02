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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


class Sample4 {

    @Composable
    fun ScreensTest() {
        Column {
            StartScreen()
            MiddleScreen1()
            MiddleScreen2()
            MiddleScreen3()
            MiddleScreen4()
            EndScreen()
        }
    }

    @Composable
    private fun StartScreen() {
        Text("StartScreen")
    }

    @Composable
    private fun MiddleScreen1() {
        Text("MiddleScreen1")
    }
    @Composable
    private fun MiddleScreen2() {
        Text("MiddleScreen2")
    }

    @Composable
    private fun MiddleScreen3() {
        Text("MiddleScreen3")
    }
    @Composable
    private fun MiddleScreen4() {
        Text("MiddleScreen4")
    }




    @Composable
    private fun EndScreen() {
        Text("EndScreen")
    }


}