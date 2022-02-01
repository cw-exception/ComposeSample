package com.test.composesample

import android.R
import android.content.Context
import android.content.res.Resources
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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


class Sample5 {

    @Composable
    @Deprecated("Example with bug")
    fun ListWithBug(myList: List<String>) {
        var items = 0

        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                for (item in myList) {
                    Text("Item: $item")
                    items++ // Avoid! Side-effect of the column recomposing.
                }
            }
            Text("Count: $items")
        }
    }


}