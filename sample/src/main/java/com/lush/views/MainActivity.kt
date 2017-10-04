package com.lush.views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lush.views.sample.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quantity.setOnClickListener { startActivity<QuantitySampleActivity>() }
        spinners.setOnClickListener { startActivity<SpinnerSampleActivity>() }
        ratings.setOnClickListener { startActivity<RatingSampleActivity>() }
        forms.setOnClickListener { startActivity<FormSampleActivity>() }
        youtube.setOnClickListener { startActivity<YoutubeSampleActivity>() }
        webviews.setOnClickListener { startActivity<WebViewSampleActivity>() }
        images.setOnClickListener { startActivity<ImageSampleActivity>() }
    }
}