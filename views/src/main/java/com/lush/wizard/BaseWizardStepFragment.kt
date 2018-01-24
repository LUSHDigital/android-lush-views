package com.lush.wizard

import android.support.v4.app.Fragment

/**
 * The base class for any steps required in a wizard flow.
 */
abstract class BaseWizardStepFragment: Fragment(), TitledPage
{
	protected open fun next()
	{
		if (parentFragment != null && parentFragment is BaseWizardFragment)
		{
			(parentFragment as BaseWizardFragment).nextStep()
		}
	}
}
