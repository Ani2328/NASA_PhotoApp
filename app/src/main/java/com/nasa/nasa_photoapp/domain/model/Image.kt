package com.nasa.nasa_photoapp.domain.model

/**
 * Created by Anitha Jasmine G on 18/08/22.
 */
data class Image(
    val copyright: String,
    val date: String,
    val explanation: String,
    val hdurl: String,
    val media_type: String,
    val service_version: String,
    val title: String,
    val url: String
)
