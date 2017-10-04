package com.lush.views.sample.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lush.views.sample.R
import org.jetbrains.anko.toast

/**
 * Demonstrates what Lush views looks like for web views
 *
 * @author Jamie Cruwys
 */
class WebViewSampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        toast("Webviews")
    }
}