package com.test.composesample.sampleState

import android.R
import android.content.Context
import android.content.res.Resources
import android.os.Parcelable
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
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.unit.dp
import com.test.composesample.TAG
import kotlinx.parcelize.Parcelize


class SampleState4RestoringState {
    // Normal - 제일 간단한 방법은 state object를parcelize로 바꿔서 저장하는 방법
    @Parcelize
    data class CityOne(val name: String, val country: String) : Parcelable

    @Composable
    fun CityScreen() {
        var selectedCity = rememberSaveable {
            mutableStateOf(CityOne("Madrid", "Spain"))
        }
    }



//    MapSaver
//    Map 형태인 key / value로 object의 속성 값을 직접 지정하여, 저장할 방법을 명시해 줄 수도 있습니다
    data class CityMapSaver(val name: String, val country: String)

    val CityMapSaveSaver = run {
        val nameKey = "Name"
        val countryKey = "Country"
        mapSaver(
            save = { mapOf(nameKey to it.name, countryKey to it.country) },
            restore = { CityMapSaver(it[nameKey] as String, it[countryKey] as String) }
        )
    }

    @Composable
    fun CityScreenMapSaver() {
        var selectedCity = rememberSaveable(stateSaver = CityMapSaveSaver) {
            mutableStateOf(CityMapSaver("Madrid", "Spain"))
        }
    }


//    ListSaver
//    좀 더 간단하게 list 형태로도 StateSaver를 만들 수 있습니다. [1]
    data class CityListSaver(val name: String, val country: String)

    val CityListSaveSaver = listSaver<CityListSaver, Any>(
        save = { listOf(it.name, it.country) },
        restore = { CityListSaver(it[0] as String, it[1] as String) }
    )

    @Composable
    fun CityScreenListSaver() {
        var selectedCity = rememberSaveable(stateSaver = CityListSaveSaver) {
            mutableStateOf(CityListSaver("Madrid", "Spain"))
        }
    }
}