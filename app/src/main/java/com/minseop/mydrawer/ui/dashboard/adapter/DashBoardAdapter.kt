package com.minseop.mydrawer.ui.dashboard.adapter

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.minseop.mydrawer.model.local.entity.Content
import com.minseop.mydrawer.service.clipboard.ContentType
import com.minseop.mydrawer.ui.base.BaseViewHolder
import com.minseop.mydrawer.ui.dashboard.adapter.view.ImageViewHolder
import com.minseop.mydrawer.ui.dashboard.adapter.view.TextViewHolder
import com.minseop.mydrawer.ui.dashboard.adapter.view.VideoViewHolder


class DashBoardAdapter : RecyclerView.Adapter<BaseViewHolder<ViewDataBinding, Content>>() {

    private var contents: List<Content> = listOf()

    fun setContent(contents: List<Content>?) {
        this.contents = contents ?: listOf()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ViewDataBinding, Content> {
        return when(viewType) {
            ContentType.PAGE.index -> TextViewHolder.newInstance(parent)
            ContentType.IMAGE.index -> ImageViewHolder.newInstance(parent)
            ContentType.VIDEO.index -> VideoViewHolder.newInstance(parent)
            ContentType.YOUTUBE.index -> VideoViewHolder.newInstance(parent)
            else -> TextViewHolder.newInstance(parent)
        }
    }

    override fun getItemCount(): Int = contents.size

    override fun onBindViewHolder(holder: BaseViewHolder<ViewDataBinding, Content>, position: Int) {
        holder.onBind(contents[position])
    }

    override fun getItemViewType(position: Int): Int {
        return contents[position].type
    }


}