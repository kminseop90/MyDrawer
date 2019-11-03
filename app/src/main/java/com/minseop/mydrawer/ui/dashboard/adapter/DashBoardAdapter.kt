package com.minseop.mydrawer.ui.dashboard.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.minseop.mydrawer.model.local.entity.Content
import com.minseop.mydrawer.ui.dashboard.adapter.view.TextViewHolder


class DashBoardAdapter : RecyclerView.Adapter<TextViewHolder>() {

    private var contents: List<Content> = listOf()

    fun setVideos(contents: List<Content>) {
        this.contents = contents
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        return TextViewHolder.newInstance(parent)
    }

    override fun getItemCount(): Int = contents.size

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.onBind(contents[position])
    }
}