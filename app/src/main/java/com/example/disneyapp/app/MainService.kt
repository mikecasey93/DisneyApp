package com.example.disneyapp.app

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast
import com.example.disneyapp.R

class MainService : Service() {

    var musicPlayer: MediaPlayer? = null

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        musicPlayer = MediaPlayer.create(this, R.raw.the_lion_king_circle_of_life)
        musicPlayer!!.isLooping = true
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "Music Playing", Toast.LENGTH_LONG).show()
        musicPlayer!!.start()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        musicPlayer!!.stop()
        Toast.makeText(this, "Music stooping playing.", Toast.LENGTH_LONG).show()
    }
}