package com.minseop.mydrawer.ui.dashboard.adapter.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.minseop.mydrawer.R
import com.minseop.mydrawer.model.local.entity.Video
import kotlinx.android.synthetic.main.item_text.view.*

class TextViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_text, parent, false)) {

    fun bind(item: Video) {
        itemView.tv_title.text = item.title
    }

}
