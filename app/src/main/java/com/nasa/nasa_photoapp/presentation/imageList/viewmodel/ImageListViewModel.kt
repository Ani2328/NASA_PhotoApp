package com.nasa.nasa_photoapp.presentation.imageList.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nasa.nasa_photoapp.data.reader.JsonReader
import com.nasa.nasa_photoapp.domain.model.Image
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Anitha Jasmine G on 17/08/22.
 */
@HiltViewModel
class ImageListViewModel @Inject constructor(val jsonReader: JsonReader) : ViewModel() {

    val imageListState: MutableLiveData<MutableList<Image>?> = MutableLiveData()

    fun getJsonDataFromAsset(context: Context) {
        viewModelScope.launch {
            val imageState = jsonReader.getData(context)
            imageListState.value = imageState
        }
    }
}