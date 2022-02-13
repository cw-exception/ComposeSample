package com.test.composesample.sampleScaffold

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.test.composesample.App
import com.test.composesample.TAG
import com.test.composesample.ui.theme.ComposeSampleTheme

class SampleScaffold1 {
    @Composable
    fun MyApp(content: @Composable () -> Unit) {
        ComposeSampleTheme {
            content()
        }
    }

    @Composable
    fun MainScreen() {
        Scaffold(topBar = {
            Text("Layout Sample",
                style = MaterialTheme.typography.h3,
                maxLines = 1
            )
        }) { innerPadding ->
            BodyContent(Modifier.padding(innerPadding))
        }
    }

    @Composable
    fun MainScreen2() {
        Scaffold(topBar = {
            TopAppBar(title = {
                Text("Layout Sample")
            },
            actions = {
                IconButton(onClick = {
                    Log.v(TAG, "$TAG onClick Favorite")
                    Toast.makeText(App.getApplication().applicationContext, "$TAG onClick Favorite", Toast.LENGTH_SHORT ).show()
                }) {
                    Icon(Icons.Filled.Favorite, contentDescription = "favorite")
                }
                IconButton(onClick = {
                    Log.v(TAG, "$TAG onClick ArrowForward")
                    Toast.makeText(App.getApplication().applicationContext, "$TAG onClick ArrowForward", Toast.LENGTH_SHORT ).show()
                }) {
                    Icon(Icons.Filled.ArrowForward, contentDescription = "ArrowForward")
                }
            })
        }) { innerPadding ->
            BodyContent(Modifier.padding(innerPadding))
        }
    }

    @Composable
    fun BodyContent(modifier: Modifier = Modifier) {
        Column(modifier = modifier) {
            Text("Hello it's main text")
            Text("Welcome to Composable world.")
        }
    }
}