package com.lush.views.sample

import android.os.Bundle
import com.lush.views.sample.base.BaseSampleActivity
import org.jetbrains.anko.toast

/**
 * Demonstrates what Lush views looks like for web views
 *
 * @author Jamie Cruwys
 */
class WebViewSampleActivity : BaseSampleActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        toast("Webviews")
    }
}