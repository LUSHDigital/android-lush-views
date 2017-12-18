package com.lush.views.sample

import android.os.Bundle
import com.lush.fragment.WebViewFragment
import com.lush.fragment.WebViewSupportFragment
import com.lush.views.sample.base.BaseSampleActivity
import kotlinx.android.synthetic.main.activity_webview.*
import org.jetbrains.anko.toast

/**
 * Demonstrates what Lush views looks like for web views
 *
 * @author Jamie Cruwys, Gokhan
 */
class WebViewSampleActivity : BaseSampleActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_webview)

		button_support_webview.setOnClickListener {
			val fragment = WebViewSupportFragment.instantiate(url_field.text.toString())
			supportFragmentManager.beginTransaction().replace(fragment_container.id,
					fragment).commit()
		}

		button_webview.setOnClickListener {
			val fragment = WebViewFragment.instantiate(url_field.text.toString())
			fragmentManager.beginTransaction().replace(fragment_container.id, fragment).commit()
		}
		toast("Webviews")
	}
}