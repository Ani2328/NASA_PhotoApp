package com.nasa.nasa_photoapp.data.di

import com.nasa.nasa_photoapp.data.reader.JsonReader
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Anitha Jasmine G on 19/08/22.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideJsonReader()=JsonReader()
}