package com.minseop.mydrawer.ui.dashboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.minseop.mydrawer.R
import com.minseop.mydrawer.model.local.entity.Video
import com.minseop.mydrawer.ui.dashboard.adapter.view.TextViewHolder
import com.minseop.mydrawer.viewmodel.DashBoardViewModel


class DashBoardAdapter : RecyclerView.Adapter<TextViewHolder>() {

    private var videos: List<Video> = listOf()
    private var viewModel: DashBoardViewModel? = null

    fun setViewModel(viewModel: DashBoardViewModel) {
        this.viewModel = viewModel
    }

    fun setVideos(videos: List<Video>) {
        this.videos = videos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        return TextViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_text, parent, false))
    }

    override fun getItemCount(): Int = videos.size

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.binding.item = videos[position]
    }


}