package com.lush.wizard

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.lush.view.R

/**
 * Fragment designed for progressing through a given collection
 * of steps (Implementations of Fragment).
 */
abstract class BaseWizardFragment: Fragment()
{
	private val KEY_CURRENT_POSITION = "current_position"
	private val TAG_CURRENT_FRAGMENT = "current_fragment"

	private var steps: List<BaseWizardStepFragment> = ArrayList()
	private val indicatorGroup: LinearLayout? by lazy { view?.findViewById<LinearLayout>(R.id.indicator_group) }
	private val title: TextView? by lazy { view?.findViewById<TextView>(R.id.title) }
	private val stepTitle: TextView? by lazy { view?.findViewById<TextView>(R.id.subtitle) }
	private var currentStep = 0

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
	{
		return inflater.inflate(R.layout.fragment_wizard, container, false)
	}

	override fun onActivityCreated(savedInstanceState: Bundle?)
	{
		super.onActivityCreated(savedInstanceState)
		steps = getSteps()
		title?.text = getTitle()
		currentStep = if (savedInstanceState?.containsKey(KEY_CURRENT_POSITION) == true)
		{
			savedInstanceState.getInt(KEY_CURRENT_POSITION)
		}
		else 0
		updateFragment()
		updateIndicator()
		updateSubtitle()
	}

	override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray)
	{
		// Pass this to the current fragment so it can deal with the permissions itself
		super.onRequestPermissionsResult(requestCode, permissions, grantResults)
		val fragment = childFragmentManager.findFragmentByTag(TAG_CURRENT_FRAGMENT)
		fragment?.onRequestPermissionsResult(requestCode, permissions, grantResults)
	}

	fun nextStep()
	{
		currentStep++
		if (currentStep == steps.size)
		{
			onWizardComplete()
		}
		else
		{
			updateFragment()
			updateIndicator()
			updateSubtitle()
		}
	}

	private fun updateSubtitle()
	{
		val fragment = steps[currentStep]
		stepTitle?.text = (fragment as TitledPage).getTitle()
	}

	private fun updateFragment()
	{
		if (context != null)
		{
			// Do this check to know if we're still the active fragment
			childFragmentManager
					.beginTransaction()
					.replace(R.id.current_fragment, steps[currentStep], TAG_CURRENT_FRAGMENT)
					.commit()
		}
	}

	private fun updateIndicator()
	{
		val numberIndicators = steps.size
		if (indicatorGroup?.childCount != numberIndicators)
		{
			indicatorGroup?.removeAllViews()
			val density = resources.displayMetrics.density
			val margin = (12 * density).toInt()
			val size = (12 * density).toInt()
			for (i in 0 until numberIndicators)
			{
				val params = LinearLayout.LayoutParams(size, size)
				params.setMargins(margin, margin, margin, margin)
				val imageView = ImageView(context)
				imageView.layoutParams = params
				indicatorGroup?.addView(imageView)
			}
		}
		for (i in 0 until numberIndicators)
		{
			val drawable: Int = if (i <= currentStep)
			{
				R.drawable.ic_wizard_indicator_active
			}
			else
			{
				R.drawable.ic_wizard_indicator_inactive
			}
			(indicatorGroup?.getChildAt(i) as ImageView).setImageResource(drawable)
		}
	}

	fun cancelWizard() = activity?.onBackPressed()

	abstract fun getSteps(): List<BaseWizardStepFragment>
	abstract fun getTitle(): String
	abstract fun onWizardComplete()
}