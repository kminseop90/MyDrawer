package com.minseop.mydrawer.ui.dashboard.adapter

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.minseop.mydrawer.model.local.entity.Content
import com.minseop.mydrawer.ui.base.BaseViewHolder
import com.minseop.mydrawer.ui.dashboard.adapter.view.ImageViewHolder
import com.minseop.mydrawer.ui.dashboard.adapter.view.TextViewHolder


class DashBoardAdapter : RecyclerView.Adapter<BaseViewHolder<ViewDataBinding, Content>>() {

    private var contents: List<Content> = listOf()

    fun setVideos(contents: List<Content>) {
        this.contents = contents
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ViewDataBinding, Content> {
        return when(viewType) {
            0 -> TextViewHolder.newInstance(parent)
            1 -> ImageViewHolder.newInstance(parent)
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