package com.example.nefis

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView

class PlayActivity : FragmentActivity() {

    companion object {
        const val MOVIE_EXTRA = "extra:movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        val videoView = findViewById<VideoView>(R.id.videoView)
        val textDescription = findViewById<TextView>(R.id.textDescription)

        val video: Video? = intent.getParcelableExtra(PlayActivity.MOVIE_EXTRA)

        var path = ""
        if (video != null) {
            path = "android.resource://" + packageName + "/" + video.video

            // mostrar descripción
            textDescription.text = video.description
            textDescription.visibility = TextView.VISIBLE

            // ocultar después de 5 segundos
            Handler(Looper.getMainLooper()).postDelayed({
                textDescription.visibility = TextView.GONE
            }, 5000)
        }

        val uri = Uri.parse(path)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()
    }
}
