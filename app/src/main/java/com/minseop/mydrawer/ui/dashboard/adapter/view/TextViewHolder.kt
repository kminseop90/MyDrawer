package com.minseop.mydrawer.ui.dashboard.adapter.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.minseop.mydrawer.R
import com.minseop.mydrawer.databinding.ItemTextBinding
import com.minseop.mydrawer.model.local.entity.Video
import com.minseop.mydrawer.ui.base.BaseViewHolder

class TextViewHolder(view: View) : BaseViewHolder<ItemTextBinding, Video>(view) {

    companion object {
        fun newInstance(parent: ViewGroup?): TextViewHolder {
            val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_text, parent, false)
            return TextViewHolder(view)
        }
    }

    override fun onBind(item: Video) {
        binding.item = item
    }
}
