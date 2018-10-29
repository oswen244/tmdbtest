package com.example.tmdbtest.data.models

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.tmdbtest.utils.Contants


class Movie(var id: Int,
            var originalTitle: String,
            var posterPath: String,
            var backDropPath: String,
            var overView: String,
            var releaseDate: String,
            var voteCount: Int) {

    companion object {

        @BindingAdapter("android:posterPath")
        @JvmStatic
        fun loadImage(view: ImageView, imageUrl: String) {
            Glide.with(view.getContext())
                .load(Contants.IMAGES + imageUrl)
                .into(view)
        }

    }
}