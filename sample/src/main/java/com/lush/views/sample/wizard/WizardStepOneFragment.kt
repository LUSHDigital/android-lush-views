package com.lush.views.sample.wizard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lush.views.sample.R
import com.lush.wizard.BaseWizardStepFragment
import kotlinx.android.synthetic.main.fragment_wizard_step.*

class WizardStepOneFragment: BaseWizardStepFragment()
{
	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
	{
		return inflater.inflate(R.layout.fragment_wizard_step, container, false)
	}

	override fun onActivityCreated(savedInstanceState: Bundle?)
	{
		super.onActivityCreated(savedInstanceState)
		step_title?.text = "Step One Title"
		button?.setOnClickListener { next() }
	}

	override fun getTitle(): String = "Step One"
}