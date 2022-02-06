package com.test.composesample.sampleSlotAPI

import android.content.Context
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import com.test.composesample.R

class SampleSlotAPI1 {

    @Composable
    fun MakeButton()
    {
        Button(onClick = {}) {
            Row {
                Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "")
                Text( "BUTTON",
                    modifier = Modifier.padding(start = 4.dp)
                    .align(Alignment.CenterVertically)
                )
            }
        }
    }



}