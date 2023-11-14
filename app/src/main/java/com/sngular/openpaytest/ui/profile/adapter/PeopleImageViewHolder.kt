package com.sngular.openpaytest.ui.profile.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sngular.domain.model.Movie
import com.sngular.domain.model.PeopleImage
import com.sngular.openpaytest.databinding.ItemMovieLayoutBinding
import com.sngular.openpaytest.ui.utils.GlideHelper
import com.sngular.openpaytest.ui.utils.urlPost

class PeopleImageViewHolder(private val binding: ItemMovieLayoutBinding) : ViewHolder(binding.root) {

    public fun bind( peopleImage: PeopleImage){
        peopleImage.filePath?.let {
            GlideHelper.invoke(it.urlPost(), binding.imageView)
            binding.textView.text = it
        }
    }
}