package com.sngular.openpaytest.ui.gallery.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.sngular.domain.model.UserImage
import com.sngular.openpaytest.databinding.ItemUserImageLayoutBinding

class UserImagesAdapter : androidx.recyclerview.widget.ListAdapter<UserImage, UserImageViewHolder>(Comparator ){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserImageViewHolder {
        val itemView = ItemUserImageLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserImageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserImageViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item,position)
    }

}

object Comparator: DiffUtil.ItemCallback<UserImage>() {
    override fun areItemsTheSame(oldItem: UserImage, newItem: UserImage): Boolean =
        oldItem.imagePath == newItem.imagePath

    override fun areContentsTheSame(oldItem: UserImage, newItem: UserImage): Boolean =
        oldItem.imagePath == newItem.imagePath
}