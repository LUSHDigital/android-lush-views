package com.lush.views.sample.wizard

import android.support.v4.app.Fragment
import com.lush.wizard.BaseWizardFragment
import java.util.*

class WizardFragment: BaseWizardFragment()
{
	override fun getSteps(): List<Fragment>
	{
		return Arrays.asList(
				WizardStepOneFragment(),
				WizardStepTwoFragment()
		)
	}

	override fun onWizardComplete()
	{
		activity?.onBackPressed()
	}

	override fun getTitle(): String = "Example Wizard Fragment"
}