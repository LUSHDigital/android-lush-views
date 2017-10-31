package com.lush.views.sample

import android.os.Bundle
import com.lush.views.sample.base.BaseSampleActivity
import kotlinx.android.synthetic.main.activity_youtube.*

/**
 * Demonstrates what Lush views looks like for Youtube content
 *
 * @author Jamie Cruwys
 */
class YoutubeSampleActivity : BaseSampleActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube)

        header.title = "Mask Of Magnaminty Self-Preserving"
        header.subtitle = "Gently cleansed"
        header.imageUrl = "http://res.cloudinary.com/lush/image/upload/v1397749336/Mask%20of%20Mag%20SP.jpg"
        header.videoUrl = "https://2ca44debfeca121cd307-a27b90ec16c2bed8bcbb29ea8980059a.ssl.cf3.rackcdn.com/Mask%20of%20Magnaminty%20(Unpreserved).mp4"
    }
}