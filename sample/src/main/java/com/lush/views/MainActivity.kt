package com.lush.views

import android.os.Bundle
import com.lush.views.base.BaseActivity
import com.lush.views.sample.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : BaseActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		javalist.setOnClickListener { startActivity<JavaListSampleActivity>() }
		list.setOnClickListener { startActivity<ListSampleActivity>() }
		buttons.setOnClickListener { startActivity<ButtonsSampleActivity>() }
		text.setOnClickListener { startActivity<TextSampleActivity>() }
		quantity.setOnClickListener { startActivity<QuantitySampleActivity>() }
		spinners.setOnClickListener { startActivity<SpinnerSampleActivity>() }
		ratings.setOnClickListener { startActivity<RatingSampleActivity>() }
		forms.setOnClickListener { startActivity<FormSampleActivity>() }
		youtube.setOnClickListener { startActivity<YoutubeSampleActivity>() }
		webviews.setOnClickListener { startActivity<WebViewSampleActivity>() }
		images.setOnClickListener { startActivity<ImageSampleActivity>() }
		wizard.setOnClickListener { startActivity<WizardSampleActivity>() }
		dialogs.setOnClickListener { startActivity<DialogSampleActivity>() }
		coloured_list.setOnClickListener { startActivity<ColouredListActivity>() }
	}
}
