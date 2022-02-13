package com.test.composesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.test.composesample.sampleList.SampleList3AnimatedVisibility
import com.test.composesample.sampleScaffold.SampleScaffold1
import com.test.composesample.sampleSlotAPI.SampleSlotAPI1
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
//                    sampleState()
                    sampleList()
//                    sampleSlotAPI()

                }
            }
        }

//        setContent {
//            sampleScaffold()
//        }
    }

    @Composable
    fun sampleScaffold() {
        SampleScaffold1().apply {
            MyApp {
//                MainScreen()
                MainScreen2()
            }
        }

    }

    @Composable
    fun sampleSlotAPI() {
        SampleSlotAPI1().MakeButton()
    }


    @Composable
    fun sampleList() {
        Column {

//            SampleList1().LazyListTest()
//            SampleList1().LazyListItemListTest()
//              SampleList1().LazyColumnTest()
//            SampleListCoil2().SimpleListCoilSimpleLazyLoad()
//            SampleListCoil2().sampleAutoAnimateScrolling()
            SampleList3AnimatedVisibility().SimpleList()

//            SampleList5_1().ListHorizontalPrint(100)
//            SampleList5_1().ListVerticalPrint(100)
//            SampleList5_2().ListVerticalPrint(listNum = 100)

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

//            SampleState4ViewModel().HelloScreen()

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

