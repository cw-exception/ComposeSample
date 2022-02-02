package com.test.composesample

import android.R
import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import com.test.composesample.sampleState.*
import com.test.composesample.samplebasic.*
import com.test.composesample.ui.theme.ComposeSampleTheme
import dagger.hilt.android.AndroidEntryPoint

val TAG = "COMPOSE_TEST"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
//                    samplebasic()

                    sampleState()
                }
            }
        }
    }

    @Composable
    fun sampleState() {
        val scrollState = rememberScrollState()
        Column(modifier = Modifier.scrollable(scrollState, Orientation.Vertical))
        {

//            SampleState1().HelloContent()
//            SampleState2().HelloContent()
//            SampleState3().HelloScreen()

            SampleState4ViewModel().HelloScreen()
        }
    }

    @Composable
    fun samplebasic() {
        val scrollState = rememberScrollState()
        Column(modifier = Modifier.scrollable(scrollState, Orientation.Vertical))
        {
            Greeting("Android")

            Column {
                Greeting("Hello Compose")
                Sample1().TestScreenContents()
            }
            Sample2().TestClickCounter(buttonNum = 5, this@MainActivity)
            Sample3().TestScreenContents()
            Sample4().ScreensTest()

    //                     해봤는데 잘됨..
            var list:ArrayList<String> = ArrayList()
            for (i in 1..10)
                list.add("$i")
            Sample5().ListWithBug(myList = list  )
        }
    }

    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeSampleTheme {
            Greeting("Android JetPack Compose")
        }
    }

}

