package com.lush.views.sample.wizard

import com.lush.wizard.BaseWizardFragment
import com.lush.wizard.BaseWizardStepFragment
import java.util.*

class WizardFragment: BaseWizardFragment()
{
	override fun getSteps(): List<BaseWizardStepFragment>
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