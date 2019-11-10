package com.minseop.mydrawer.ui.dashboard.adapter.view

import android.app.Activity
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubeStandalonePlayer
import com.google.android.youtube.player.YouTubeThumbnailLoader
import com.google.android.youtube.player.YouTubeThumbnailView
import com.minseop.mydrawer.R
import com.minseop.mydrawer.databinding.ItemVideoBinding
import com.minseop.mydrawer.model.local.entity.Content
import com.minseop.mydrawer.ui.base.BaseViewHolder


class VideoViewHolder(view: View) : BaseViewHolder<ItemVideoBinding, Content>(view) {

    private var readyForLoadingYoutubeThumbnail = true

    companion object {
        fun newInstance(parent: ViewGroup): VideoViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
            return VideoViewHolder(view)
        }
    }

    override fun onBind(item: Content) {
        binding.item = item
        val context = binding.root.context

        if (readyForLoadingYoutubeThumbnail) {
            readyForLoadingYoutubeThumbnail = false
            binding.youtubeVideo.initialize(context.getString(R.string.youtube_api_key), object : YouTubeThumbnailView.OnInitializedListener {
                override fun onInitializationSuccess(youTubeThumbnailView: YouTubeThumbnailView, youTubeThumbnailLoader: YouTubeThumbnailLoader) {
                    youTubeThumbnailLoader.setVideo(item.url)
                    youTubeThumbnailLoader.setOnThumbnailLoadedListener(object : YouTubeThumbnailLoader.OnThumbnailLoadedListener {

                        override fun onThumbnailLoaded(childYouTubeThumbnailView: YouTubeThumbnailView, s: String) {
                            childYouTubeThumbnailView.visibility = View.VISIBLE
                            youTubeThumbnailLoader.release()
                        }

                        override fun onThumbnailError(youTubeThumbnailView: YouTubeThumbnailView, errorReason: YouTubeThumbnailLoader.ErrorReason) {
                            youTubeThumbnailLoader.release()
                        }
                    })

                    youTubeThumbnailView.setColorFilter(
                        Color.rgb(123, 123, 123),
                        android.graphics.PorterDuff.Mode.MULTIPLY
                    )

                    readyForLoadingYoutubeThumbnail = true
                }

                override fun onInitializationFailure(
                    youTubeThumbnailView: YouTubeThumbnailView,
                    youTubeInitializationResult: YouTubeInitializationResult
                ) {
                    readyForLoadingYoutubeThumbnail = true
                }
            })
        }

        binding.youtubeVideo.setOnClickListener {
            context?.let {
                val intent = YouTubeStandalonePlayer.createPlaylistIntent(
                    it as Activity,
                    it.getString(R.string.youtube_api_key),
                    item.url
                )
                it.startActivity(intent)
            }
        }


    }

}
