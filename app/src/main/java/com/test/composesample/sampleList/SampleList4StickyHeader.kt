package com.test.composesample.sampleList

import android.R
import android.content.ClipData
import android.content.Context
import android.content.res.Resources
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.test.composesample.ui.theme.COLORS_RAINBOW
import com.test.composesample.ui.theme.COLOR_SET_SIZE
import kotlinx.coroutines.launch


@ExperimentalFoundationApi
class SampleList4StickyHeader {

    @Composable
    fun ListWithHeader()
    {
        LazyColumn {
            stickyHeader {
                Text(text = "Sticky Header",
                    modifier = Modifier.background(Color.Green)
                        .fillMaxWidth())
            }
            // Add a single item
            item {
                Text(text = "First item",
                    modifier = Modifier.background(Color.Yellow)
                        .fillMaxWidth())
            }

            // Add 5 items
            items(135) { index ->
                Text(text = "Item: $index",
                    modifier = Modifier.background(Color.Gray)
                        .fillMaxWidth())
            }

            // Add another single item
            item {
                Text(text = "Last item",
                    modifier = Modifier.background(Color.Magenta)
                        .fillMaxWidth())
            }
        }
    }
}