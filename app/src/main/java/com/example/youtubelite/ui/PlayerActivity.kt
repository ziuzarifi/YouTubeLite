package com.example.youtubelite.ui

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import com.example.youtubelite.R
import com.example.youtubelite.databinding.ActivityPlayerBinding
import com.example.youtubelite.utils.Constants.Companion.YOUTUBE_API_KEY
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

class PlayerActivity : YouTubeBaseActivity() {

    private lateinit var binding: ActivityPlayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val youTubePlayerView : YouTubePlayerView = findViewById(R.id.youtubePlayerView)

        val videoId = intent.getStringExtra("YOUTUBE_VIDEO_ID")

        youTubePlayerView.initialize(YOUTUBE_API_KEY,
            object : YouTubePlayer.OnInitializedListener {
                override fun onInitializationSuccess(
                    provider: YouTubePlayer.Provider?,
                    player: YouTubePlayer?,
                    bool: Boolean
                ) {
                    player?.loadVideo(videoId)
                    player?.play()
                }

                override fun onInitializationFailure(
                    provider: YouTubePlayer.Provider?,
                    result: YouTubeInitializationResult?
                ) {
                    Log.d(ContentValues.TAG, "onInitializationFailure: An Error occurred")
                }
            })
    }
}