package com.lush.views.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.toast

/**
 * Demonstrates what Lush views looks like for Youtube content
 *
 * @author Jamie Cruwys
 */
class YoutubeSampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube)

        toast("Youtube")
    }
}