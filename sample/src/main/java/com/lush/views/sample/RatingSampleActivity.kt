package com.lush.views.sample

import android.os.Bundle
import com.lush.views.sample.base.BaseSampleActivity
import kotlinx.android.synthetic.main.activity_rating.*

/**
 * Demonstrates what Lush views looks like for ratings and reviews
 *
 * @author Jamie Cruwys
 */
class RatingSampleActivity : BaseSampleActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating)

        rating_view.rating = 4
        editable_rating_view.rating = 3
    }
}