package com.wmall.dplay

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wmall.dplay.databinding.ItemVideoContainerBinding

class VideosAdapter : RecyclerView.Adapter<VideosAdapter.VideoViewHolder>() {
    val list = arrayListOf<VideoItem>()


    fun addVidList(list: List<VideoItem>) {
        this.list.clear()
        this.list.addAll(list)
        notifyItemRangeInserted(0, list.size)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(
            ItemVideoContainerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bindTo(list[position])
    }

    inner class VideoViewHolder(private val binding: ItemVideoContainerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindTo(video: VideoItem) {
            binding.tvVideoTitle.text = video.videoTitle
            binding.tvVideoDescription.text = video.videoDescription
            binding.progressBar
            binding.videoView.setVideoPath(video.videoUrl)

            binding.videoView.setOnPreparedListener { mediaplayer ->
                binding.progressBar.visibility = View.GONE
                mediaplayer.start()
                val videoRatio =
                    mediaplayer.videoWidth.toFloat() / mediaplayer.videoHeight.toFloat()
                val screenRatio =
                    binding.videoView.width.toFloat() / binding.videoView.height.toFloat()
                val scale = videoRatio / screenRatio
                if (scale >= 1f) {
                    binding.videoView.scaleX = scale
                } else {
                    binding.videoView.scaleY = 1f / scale
                }

            }
            binding.videoView.setOnCompletionListener {
                it.start()
            }
        }
    }


}