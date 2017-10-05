package com.lush.views.sample

import android.os.Bundle
import com.lush.views.sample.base.BaseSampleActivity
import org.jetbrains.anko.toast

/**
 * Demonstrates what Lush views looks like for generic spinners/pickers
 *
 * @author Jamie Cruwys
 */
class SpinnerSampleActivity : BaseSampleActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        toast("Spinner")
    }
}