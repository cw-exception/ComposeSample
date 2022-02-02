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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.test.composesample.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SampleState4ViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel()
{

        // LiveData holds state which is observed by the UI
        // (state flows down from ViewModel)
        private val _name = MutableLiveData("")
        val name: LiveData<String> = _name
        // onNameChange is an event we're defining that the UI can invoke
        // (events flow up from UI)
        fun onNameChange(newName: String) {
            _name.value = newName
        }
    }

    @Composable
    fun HelloScreen(mainViewModel: MainViewModel = viewModel())
    {
        // by default, viewModel() follows the Lifecycle as the Activity or Fragment
        // that calls HelloScreen(). This lifecycle can be modified by callers of HelloScreen.

        // name is the current value of [helloViewModel.name]
        // with an initial value of ""
        val name: String by mainViewModel.name.observeAsState("")
        HelloContent(name = name, onNameChange = { mainViewModel.onNameChange(it) })
    }

    @Composable
    fun HelloContent(name: String, onNameChange: (String) -> Unit) {
        ...
    }
}