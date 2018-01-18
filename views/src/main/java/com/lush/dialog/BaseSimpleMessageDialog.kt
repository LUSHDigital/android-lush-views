package com.lush.dialog

import android.widget.Button
import android.widget.TextView
import com.lush.view.R

/**
 * A simple dialog to present a message to the user.
 * This is intended for any real interaction, only to inform the user.
 */
abstract class BaseSimpleMessageDialog: BaseDialog()
{
	override fun onInnerViewCreated()
	{
		view?.findViewById<TextView>(R.id.message)?.text = getMessage()
		view?.findViewById<Button>(R.id.close)?.setOnClickListener({ dismiss() })
	}

	override fun getLayoutResource(): Int = R.layout.dialog_message
	protected abstract fun getMessage(): String
}