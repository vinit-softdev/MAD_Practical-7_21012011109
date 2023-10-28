package com.example.mad_practical_7_21012011109

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.MediaController
import android.widget.VideoView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toYtBtn=findViewById<FloatingActionButton>(R.id.button)
        toYtBtn.setOnClickListener{
            val intent = Intent(this,YoutubeActivity::class.java)
            startActivity(intent)
        }
        initVideoPlayer()
    }
    private fun initVideoPlayer(){
        val videoView = findViewById<VideoView>(R.id.videoView)
        val mediaController = MediaController(this)
        val uri:Uri = Uri.parse("android.resource://"+ packageName + "/"+ R.raw.video)

        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
    }
}