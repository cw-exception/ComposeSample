package com.test.composesample.sampleState

import android.R
import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.unit.dp
import com.test.composesample.TAG


class SampleState3 {
    @Composable
    fun HelloScreen() {
        var name by rememberSaveable { mutableStateOf("") }   // Configuration Changed 에서도 값을 유지시켜줍니다. 회전시켜도 값이 유지됩니다.
//        var name by remember { mutableStateOf("") }   // Configure Changed에서 값을 유지시켜주지않아 회전시키면 사라집니다.
        HelloContent(name = name, onNameChange = { name = it})
    }

    @Composable
    private fun HelloContent(name: String, onNameChange: (String) -> Unit) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Hello, $name",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.h5
            )
            OutlinedTextField(
                value = name,
                onValueChange = onNameChange,
                label = {
                    Text("Name")
                }
            )
        }
    }


}