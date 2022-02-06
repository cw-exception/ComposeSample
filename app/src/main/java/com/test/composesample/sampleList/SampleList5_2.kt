package com.test.composesample.sampleList

import android.R
import android.content.Context
import android.content.res.Resources
import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.test.composesample.ui.theme.COLORS_RAINBOW
import com.test.composesample.ui.theme.COLOR_SET_SIZE


class SampleList2 {
    @Composable
    fun ListVerticalPrint(listNum:Int) {
        val array = ArrayList<String>()
        for (i in 0..listNum) {
            array.add("$i")
        }

        NameListVertical(array,
        Modifier.padding(8.dp))
    }

    @Composable
    private fun NameListVertical(names: List<String>,
                 modifier: Modifier = Modifier)
    {
        val isSelectedList = remember { mutableStateMapOf<Int, Boolean>() }
        val onItemTextClicked: (Int) -> Unit = {index ->
            isSelectedList[index] = when (isSelectedList[index]) {
                true -> false
                else -> true
            }
        }

        LazyColumn(modifier = modifier) {
            itemsIndexed(items = names)
            { index, item ->
                val name = "$index-$item"
                CounterButton2(item, index, isSelectedList[index] ?: false, onItemTextClicked)
                Divider(color = Color.DarkGray)
            }
        }
    }



    @Composable
    private fun CounterButton2(param: String, index:Int, isSelected:Boolean, click: (Int)-> Unit) {
        val backgroundColor by animateColorAsState(
            if (isSelected)
                Color.Red
            else
                Color.Transparent
        )

            Text(
                text = "Param $param",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(9.dp)
                    .background(color = backgroundColor)
                    .clickable (onClick = {  click(index) })
            )
    }

}