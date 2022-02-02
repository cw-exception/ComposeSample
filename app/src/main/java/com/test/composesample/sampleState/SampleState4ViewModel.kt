package com.test.composesample.sampleState

import android.R
import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.test.composesample.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class SampleState4ViewModel {
    @Composable
    fun HelloScreen(mainViewModel: MainViewModel = viewModel())
    {
        // by default, viewModel() follows the Lifecycle as the Activity or Fragment
        // that calls HelloScreen(). This lifecycle can be modified by callers of HelloScreen.

        // name is the current value of [helloViewModel.name]
        // with an initial value of ""
        val name: String by mainViewModel.name.observeAsState("")
        //  observeAsState는
        //implementation "androidx.compose.runtime:runtime-livedata:$compose_version" 필요

        Log.v(TAG, "$TAG SampleState4ViewModel name:$name")

        HelloContent(name = name, onNameChange = {
            Log.v(TAG, "$TAG SampleState4ViewModel onNameChange -> it:$it")
            mainViewModel.onNameChange(it)
        })
    }

    @Composable
    private fun HelloContent(name: String, onNameChange: (String) -> Unit) {
        Column(modifier = Modifier.padding(16.dp)) {
            Log.v(TAG, "$TAG SampleState4ViewModel HelloContent onNameChange:$onNameChange")
            Log.v(TAG, "$TAG SampleState4ViewModel HelloContent name:$name")
            Text(
                text = "Hello, $name",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.h5
            )
            OutlinedTextField(
                value = name,
                onValueChange = onNameChange,
                label = {
                    Text("Name")
                }
            )
        }
    }
}