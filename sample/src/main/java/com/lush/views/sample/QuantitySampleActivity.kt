package com.lush.views.sample

import android.os.Bundle
import com.lush.views.sample.base.BaseSampleActivity
import kotlinx.android.synthetic.main.activity_quantity.*

/**
 * Demonstrates what Lush views looks like for inputting quantities of product
 *
 * @author Jamie Cruwys
 */
class QuantitySampleActivity : BaseSampleActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quantity)

        quantitySpinner.maximum = 10
        quantitySpinner.quantity = 3

        quantityView.maximum = 10
        quantityView.quantity = 5
    }
}