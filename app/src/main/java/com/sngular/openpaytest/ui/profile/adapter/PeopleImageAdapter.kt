package com.sngular.openpaytest.ui.profile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sngular.domain.model.PeopleImage
import com.sngular.openpaytest.databinding.ItemMovieLayoutBinding

class PeopleImageAdapter : PagingDataAdapter<PeopleImage, RecyclerView.ViewHolder>(REPO_COMPARATOR) {
    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<PeopleImage>() {
            override fun areItemsTheSame(oldItem: PeopleImage, newItem: PeopleImage): Boolean =
                oldItem.filePath == newItem.filePath

            override fun areContentsTheSame(oldItem: PeopleImage, newItem: PeopleImage): Boolean =
                oldItem.filePath == newItem.filePath
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getItem(position)?.let { movie ->
            (holder as? PeopleImageViewHolder)?.bind(movie)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PeopleImageViewHolder(
            ItemMovieLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }


}