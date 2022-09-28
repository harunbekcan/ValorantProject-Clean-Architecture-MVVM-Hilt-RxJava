package com.harunbekcan.valorantproject.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.harunbekcan.valorantproject.R

fun ImageView.loadImage(imageUrl: String?) {
    Glide.with(this.context)
        .load(imageUrl)
        .error(R.drawable.ic_launcher_background)
        .into(this)
}