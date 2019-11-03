package com.minseop.mydrawer.ui.dashboard.adapter.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.minseop.mydrawer.R
import com.minseop.mydrawer.databinding.ItemImageBinding
import com.minseop.mydrawer.model.local.entity.Content
import com.minseop.mydrawer.ui.base.BaseViewHolder
import com.minseop.mydrawer.util.extension.load

class ImageViewHolder(view: View): BaseViewHolder<ItemImageBinding, Content>(view) {

    companion object {
        fun newInstance(parent: ViewGroup?): ImageViewHolder {
            val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_image, parent, false)
            return ImageViewHolder(view)
        }
    }

    override fun onBind(item: Content) {
        binding.item = item
        binding.ivImage.load(item.url)
    }
}
