package com.sngular.openpaytest.ui.gallery.adapter

import androidx.recyclerview.widget.RecyclerView
import com.sngular.domain.model.UserImage
import com.sngular.openpaytest.databinding.ItemUserImageLayoutBinding
import com.sngular.openpaytest.ui.utils.GlideHelper

class UserImageViewHolder(val binding: ItemUserImageLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: UserImage, position: Int) {
        item.imagePath?.let {
            GlideHelper.invoke(it, binding.imageView)
        }
    }
}