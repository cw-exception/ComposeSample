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


class SampleList1 {
    @Composable
    fun ListHorizontalPrint(listNum:Int) {
        val array = ArrayList<String>()
        for (i in 0..listNum) {
            array.add("$i | ")
        }

        NameListHorizontal(array,
            Modifier.padding(8.dp))
    }


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


        LazyColumn(modifier = modifier) {
            itemsIndexed(items = names)
            { index, item ->
                val name = "$index-$item"
                CounterButton2(name)
                Divider(color = Color.DarkGray)
            }
        }

    }



    @Composable
    private fun NameListHorizontal(names: List<String>,
                         modifier: Modifier = Modifier)
    {
        val count = remember { mutableStateOf(0)}

        LazyRow(modifier = modifier) {
            items(items = names)
            {
                CounterButton1(it, count.value) { newCnt -> count.value = newCnt }
                Divider(color = Color.DarkGray)
            }
        }
    }


    @Composable
    private fun CounterButton1(param: String, count: Int, updateCount: (Int) -> Unit) {
        var isSelected by remember { mutableStateOf(false) }
        val backgroundColor by animateColorAsState(
            if (isSelected)
                Color.Red
            else
                Color.Transparent
        )

        Button(
            onClick = {updateCount(count + 1)},
            modifier = Modifier
                .background(color = backgroundColor)
                .fillMaxWidth()
                .clickable(onClick = { isSelected = !isSelected }),
            colors = ButtonDefaults.buttonColors(
                backgroundColor= if(count % 3 == 0) Color.Green else Color.Yellow
            )
        ) {
            Text(
                text ="$param cnt:$count",
                modifier = Modifier
                    .padding(14.dp)

            )
        }

    }


    @Composable
    private fun CounterButton2(param: String) {
        val count = remember { mutableStateOf(0) }
        var isSelected by remember { mutableStateOf(false) }
        val backgroundColor by animateColorAsState(
            if (isSelected)
                Color.Red
            else
                Color.Transparent
        )


        Button(
            onClick = { count.value++ },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = COLORS_RAINBOW[count.value % COLOR_SET_SIZE]
            )

        ) {
            Text(
                text = "$param cnt:${count.value}",
                modifier = Modifier
                    .padding(9.dp)
                    .background(color = backgroundColor)
                    .clickable(onClick = { isSelected = !isSelected })

            )
        }
    }

}