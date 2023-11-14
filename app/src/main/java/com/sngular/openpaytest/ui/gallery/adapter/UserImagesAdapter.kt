package com.sngular.openpaytest.ui.gallery.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sngular.domain.model.UserImage
import com.sngular.openpaytest.databinding.ItemUserImageLayoutBinding

class UserImagesAdapter(
    val onCancelClicked: ((Int, Uri) -> Unit)? = null,
) : RecyclerView.Adapter<UserImageViewHolder>() {

    private var list: MutableList<UserImage> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserImageViewHolder {
        val itemView = ItemUserImageLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserImageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserImageViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item,position)
    }

    fun updateList(list: MutableList<UserImage>){
        this.list = list
        notifyDataSetChanged()
    }

    fun pushItem(item: UserImage){
        this.list.add(0, item)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int){
        list.removeAt(position)
        notifyItemChanged(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}