package com.lush.views.sample

import android.os.Bundle
import com.lush.views.sample.base.BaseSampleActivity
import com.lush.views.sample.wizard.WizardFragment

class WizardSampleActivity : BaseSampleActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_wizard)
		supportFragmentManager.beginTransaction().replace(R.id.fragment, WizardFragment()).commit()
	}
}
