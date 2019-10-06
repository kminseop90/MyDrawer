package com.minseop.mydrawer.ui.dashboard.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.minseop.mydrawer.model.local.entity.Video
import com.minseop.mydrawer.ui.dashboard.adapter.view.TextViewHolder


class DashBoardAdapter : RecyclerView.Adapter<TextViewHolder>() {

    private var videos: List<Video> = listOf()

    fun setVideos(videos: List<Video>) {
        this.videos = videos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        return TextViewHolder(parent)
    }

    override fun getItemCount(): Int = videos.size

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.bind(videos[position])
    }




}