package com.test.composesample.sampleList

import android.R
import android.content.Context
import android.content.res.Resources
import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
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
    fun LazyListTest() {
        // 스크롤의 position의 상태를 저장. 
        val scrollState = rememberLazyListState()

        LazyColumn(state = scrollState) {
            items(100) {
                Text("Item $it")
            }
        }
    }


    @Composable
    fun LazyListItemListTest() {
        val array = ArrayList<String>()
        for (i in 0..100)
            array.add("add $i")
        LazyListItemListTestImpl(itemList = array)
    }

    @Composable
    private fun LazyListItemListTestImpl(itemList: List<String>) {
        // 스크롤의 position의 상태를 저장. 
        val scrollState = rememberLazyListState()

        LazyColumn(state = scrollState) {
            items(items = itemList) {
                Text("Item $it")
            }
        }
    }

    @Composable
    fun LazyColumnTest() {
        LazyColumn(modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp))
        {
            item {
                Text(modifier = Modifier.background(Color.Red),
                    text = "First item")
            }
            val list = listOf("second", "third", "fourth")
            items(list) {
                Text(modifier = Modifier.background(Color.Green),
                    text = "$it item")
            }

            itemsIndexed(list) { index, item ->
                Text(modifier = Modifier.background(Color.Yellow),
                    text = "Added $item list index:$index")
            }
        }
    }


}