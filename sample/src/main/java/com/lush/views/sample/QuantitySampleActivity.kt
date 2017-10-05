package com.lush.views.sample

import android.os.Bundle
import org.jetbrains.anko.toast
import com.lush.views.sample.base.BaseSampleActivity

/**
 * Demonstrates what Lush views looks like for inputting quantities of product
 *
 * @author Jamie Cruwys
 */
class QuantitySampleActivity : BaseSampleActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quantity)

        toast("Quantities")
    }
}