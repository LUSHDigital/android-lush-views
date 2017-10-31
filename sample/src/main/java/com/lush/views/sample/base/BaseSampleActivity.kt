package com.lush.views.sample.base

import android.os.Bundle
import android.support.v4.app.NavUtils
import android.view.MenuItem
import com.lush.views.base.BaseActivity

/**
 * <Class Description>
 *
 * @author Jamie Cruwys
 */
abstract class BaseSampleActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home)
        {
            NavUtils.navigateUpFromSameTask(this)
            return true
        }
        return super.onOptionsItemSelected(item);
    }
}