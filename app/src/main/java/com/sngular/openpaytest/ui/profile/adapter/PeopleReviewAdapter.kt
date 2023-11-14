package com.sngular.openpaytest.ui.profile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sngular.domain.model.Review
import com.sngular.openpaytest.databinding.ItemReviewLayoutBinding

class PeopleReviewAdapter : PagingDataAdapter<Review, RecyclerView.ViewHolder>(REPO_COMPARATOR) {
    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<Review>() {
            override fun areItemsTheSame(oldItem: Review, newItem: Review): Boolean =
                oldItem.content == newItem.content

            override fun areContentsTheSame(oldItem: Review, newItem: Review): Boolean =
                oldItem.content == newItem.content
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getItem(position)?.let { movie ->
            (holder as? PeopleReviewViewHolder)?.bind(movie)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PeopleReviewViewHolder(
            ItemReviewLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }


}