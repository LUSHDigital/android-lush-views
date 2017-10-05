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

        quantitySpinner.maximum = 25
        quantitySpinner.quantity = 5

        quantityView.maximum = 25
        quantityView.quantity = 5
    }
}