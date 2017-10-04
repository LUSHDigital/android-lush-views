package com.lush.views.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lush.views.sample.R
import org.jetbrains.anko.toast

/**
 * Demonstrates what Lush views looks like for images, specifically Cloudinary ones
 *
 * @author Jamie Cruwys
 */
class ImageSampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        toast("Images")
    }
}