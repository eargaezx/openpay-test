package com.sngular.openpaytest.ui.profile.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sngular.domain.model.Movie
import com.sngular.domain.model.PeopleImage
import com.sngular.domain.model.Review
import com.sngular.openpaytest.databinding.ItemMovieLayoutBinding
import com.sngular.openpaytest.databinding.ItemReviewLayoutBinding
import com.sngular.openpaytest.ui.utils.GlideHelper
import com.sngular.openpaytest.ui.utils.urlPost

class PeopleReviewViewHolder(private val binding: ItemReviewLayoutBinding) : ViewHolder(binding.root) {

    public fun bind( review: Review){
        binding.textViewAuthor.text = review.author
        binding.textViewContent.text  = review.content
    }
}