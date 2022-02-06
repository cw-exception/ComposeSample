package com.test.composesample.sampleList

import android.R
import android.content.Context
import android.content.res.Resources
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
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

@OptIn(ExperimentalAnimationApi::class)
class SampleListAnimatedVisibility3 {

   @Composable
   fun SimpleList() {
       Box {
           val listSize = 100

           val scrollState = rememberLazyListState()

           Column(Modifier.fillMaxWidth()) {
               LazyColumn(
                   state = scrollState,
                   contentPadding = PaddingValues(bottom = 50.dp)
               ) {
                   items(listSize) {
                       ImageListItem(it)
                   }
               }
           }

           val showButton = remember {
               derivedStateOf {
                   scrollState.firstVisibleItemIndex > 0
               }
           }

           AnimatedVisibility(
               visible = showButton.value,
               modifier = Modifier.align(Alignment.BottomEnd)
           ) {
               ScrollToTopButton(scrollState)
           }
       }
   }

    @Composable
    fun ScrollToTopButton(scrollState: LazyListState,
                        modifier: Modifier = Modifier) {
        val scope = rememberCoroutineScope()
        Image(
            painter = painterResource(id = R.drawable.ic_menu_add),
            contentDescription = "",
            modifier
                .padding(20.dp)
                .background(color = Color.Gray,
                    shape = CircleShape)
                .clickable {
                    scope.launch { scrollState.scrollToItem(0) }
                }
        )
    }
    @Composable
    fun ImageListItem(index : Int) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = rememberImagePainter(
                    "https://developer.android.com/images/brand/Android_Robot.png",
                    // image painter가 호출하기 전에 수행되며 true이면 request, false이면 request를 skip 한다.
                    onExecute = ImagePainter.ExecuteCallback { previous, current ->  true },
                    builder = {
                        crossfade(true)
                        placeholder (R.mipmap.sym_def_app_icon)
                        transformations(CircleCropTransformation())
                    }
                ),
                contentDescription = "",
                modifier = Modifier.size(50.dp)
            )
            Spacer(Modifier.width(10.dp))
            Text("Item $index", style = MaterialTheme.typography.subtitle2)
        }
    }

    @Composable
    fun sampleAutoAnimateScrolling() {
        val listSize = 100
        // 스크롤의 position 의 상태를 저장
        val scrollState = rememberLazyListState()
        val coroutineScope = rememberCoroutineScope()

        Column(Modifier.padding(start = 10.dp, end = 10.dp)) {
            Row {
                Button(onClick = {
                    coroutineScope.launch {
                        scrollState.animateScrollToItem(0)
                    }
                }, Modifier.weight(1f)) {
                    Text("Scroll to the top")
                }
                Spacer(Modifier.width(10.dp))
                Button(onClick = {
                    coroutineScope.launch {
                        scrollState.scrollToItem(listSize -1)
                    }
                }, Modifier.weight(1f)) {
                    Text("bottom No Ani")
                }
            }
            LazyColumn(state = scrollState) {
                items(listSize) {
                    ImageListItem(it)
                }
            }
        }
    }
}