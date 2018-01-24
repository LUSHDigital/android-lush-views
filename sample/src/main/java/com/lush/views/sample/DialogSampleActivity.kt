package com.lush.views.sample

import android.os.Bundle
import com.lush.views.dialogs.ExampleMessageDialog
import com.lush.views.dialogs.StatusFailureDialog
import com.lush.views.dialogs.StatusSuccessDialog
import com.lush.views.sample.base.BaseSampleActivity
import kotlinx.android.synthetic.main.activity_dialogs.*

class DialogSampleActivity: BaseSampleActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_dialogs)
		message.setOnClickListener { ExampleMessageDialog().show(fragmentManager) }
		status_success.setOnClickListener { StatusSuccessDialog().show(fragmentManager) }
		status_failure.setOnClickListener { StatusFailureDialog().show(fragmentManager) }
	}
}