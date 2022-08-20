package com.nasa.nasa_photoapp.data.reader

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nasa.nasa_photoapp.domain.model.Image
import dagger.hilt.android.scopes.ActivityRetainedScoped
import java.io.IOException
import javax.inject.Inject

/**
 * Created by Anitha Jasmine G on 19/08/22.
 */
class JsonReader {
    lateinit var jsonString: String
    fun getData(context:Context): MutableList<Image>?
    {
        try {
            jsonString = context.assets.open("data.json").bufferedReader().use { it.readText() }
            //Log.i("data", jsonString)
            val gson = Gson()
            val listPersonType = object : TypeToken<List<Image>>() {}.type
            val images: MutableList<Image> = gson.fromJson(jsonString, listPersonType)
            return images

        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
    }

}