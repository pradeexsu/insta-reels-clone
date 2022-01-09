package com.wmall.dplay

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wmall.dplay.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val vidList = listOf(
            VideoItem(
                videoTitle = "Celebration!!!",
                videoDescription = "Celebrate who you are in you deepest heart. love yourself and world will love you!!",
                videoUrl = "https://www.statuslagao.com/whatsapp/videos/new/new-whatsapp-status-video-783.mp4"
            ),
            VideoItem(
                videoTitle = "Celebration!!!",
                videoDescription = "Celebrate who you are in you deepest heart. love yourself and world will love you!!",
                videoUrl = "https://www.statuslagao.com/whatsapp/videos/new/new-whatsapp-status-video-781.mp4"
            ),
            VideoItem(
                videoTitle = "Celebration!!!",
                videoDescription = "Celebrate who you are in you deepest heart. love yourself and world will love you!!",
                videoUrl = "https://www.statuslagao.com/whatsapp/videos/new/new-whatsapp-status-video-765.mp4"
            )
        )
        val adapter = VideosAdapter()
        adapter.addVidList(vidList)
        binding.viewPager.adapter = adapter

    }
}