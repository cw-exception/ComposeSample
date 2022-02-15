package com.test.composesample.sampleMigration

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.skydoves.landscapist.glide.GlideImage
import com.test.composesample.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MigrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main_migration)
        findViewById<ComposeView>(R.id.compose_view).setContent {
            val list = ArrayList<SampleData>()
            for (index in dataURL.indices) {
                list.add(SampleData("$index", dataURL[index]))
            }

            MaterialTheme {
                LazyColumn {
                    itemsIndexed(items = list)
                    { index, item ->
                        val name = "$index-$item"
                        Card(index, item)
                        TabRowDefaults.Divider(color = Color.DarkGray)
                    }
                }
            }
        }

    }

}
@Composable
fun Card(
    index: Int,
    data: SampleData
) {
        val context = LocalContext.current
    Surface(
        modifier = Modifier
            .padding(4.dp)
            .clickable(
                onClick = {
                        Toast.makeText(context, "id ${index}", Toast.LENGTH_SHORT).show()
                },
            ),
//        color = color.value,
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {

        Row (modifier = Modifier.fillMaxWidth()
        ) {
            GlideImage(
                imageModel = data.url,
                // Crop, Fit, Inside, FillHeight, FillWidth, None
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.width(150.dp)
                    .height(150.dp)
            )
            Text(text = data.text,
            color = Color.Red)
        }
    }
}