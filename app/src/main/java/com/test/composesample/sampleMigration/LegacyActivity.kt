package com.test.composesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
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
import com.test.composesample.sampleList.SampleList4StickyHeader
import com.test.composesample.sampleMigration.SampleMigration
import com.test.composesample.sampleScaffold.SampleScaffold1
import com.test.composesample.sampleSlotAPI.SampleSlotAPI1
import com.test.composesample.samplebasic.*
import com.test.composesample.ui.theme.ComposeSampleTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LegacyActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

    
}

