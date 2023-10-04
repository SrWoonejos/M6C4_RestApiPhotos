package com.dmiranda.restapiphotos_m6c4.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dmiranda.restapiphotos_m6c4.databinding.PhotosListItemBinding
import com.dmiranda.restapiphotos_m6c4.model.Photo
import com.squareup.picasso.Picasso

class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = PhotosListItemBinding.bind(itemView)

    }
    fun render(photo: Photo) {
        Picasso.get()
            .load(photo.url)
            .into(binding.imageViewPhoto)

        Picasso.get()
        binding.setIndicatorsEnabled(true)
    }
}