package com.sngular.openpaytest.ui.utils

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sngular.openpaytest.BuildConfig
import com.sngular.openpaytest.ui.movies.adapter.MoviesAdapter

fun String.urlPost() = BuildConfig.URL_IMAGE.plus(this)


fun RecyclerView.fetchMoviesAdapter(): MoviesAdapter{
    val _adapter  = MoviesAdapter()
    layoutManager = GridLayoutManager(context, 1,  GridLayoutManager.HORIZONTAL, false)
    //adapter setup
    adapter = _adapter
    setHasFixedSize(true)
    return _adapter
}