package com.sngular.openpaytest.ui.movies.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sngular.domain.model.Movie
import com.sngular.openpaytest.databinding.ItemMovieLayoutBinding
import com.sngular.openpaytest.ui.utils.GlideHelper
import com.sngular.openpaytest.ui.utils.urlPost

class MovieViewHolder(private val binding: ItemMovieLayoutBinding) : ViewHolder(binding.root) {

    public fun bind( movie: Movie){
        binding.textView.text = movie.title
        movie.posterPath?.let {
            GlideHelper.invoke(it.urlPost(), binding.imageView)
        }
    }
}