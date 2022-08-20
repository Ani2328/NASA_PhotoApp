package com.nasa.nasa_photoapp.presentation.imageList.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.nasa.nasa_photoapp.R
import com.nasa.nasa_photoapp.databinding.ActivityMainBinding
import com.nasa.nasa_photoapp.presentation.imageList.viewmodel.ImageListViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class ImageListActivity : AppCompatActivity() {
    val viewModel: ImageListViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private var imageAdapter: ImageAdapter? = null

    // val viewModel by viewModels<ImageListViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getJsonDataFromAsset(this)
        setView()
    }

    fun setView() {
        viewModel.imageListState.observe(this) {
            binding.rvImageList.layoutManager = GridLayoutManager(this, 2)
            imageAdapter = it?.let { it1 -> ImageAdapter(this, it1) }
            binding.rvImageList.adapter = imageAdapter
        }
    }
}