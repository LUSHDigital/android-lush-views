package com.lush.dialog

import android.app.DialogFragment
import android.app.FragmentManager
import android.app.FragmentTransaction
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.TextView
import com.lush.view.R

/**
 * Base class for all dialogs.
 *
 * This will set the correct dimensions based on device
 * and apply our tool bar design to the top of the dialog.
 */
abstract class BaseDialog: DialogFragment(), View.OnKeyListener
{
	init
	{
		retainInstance = true
	}

	fun show(manager: FragmentManager?)
	{
		super.show(manager, null)
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
	{
		val view = inflater.inflate(R.layout.dialog_base, container, false)
		val frameLayout = view?.findViewById<FrameLayout>(R.id.container)
		val subView = inflater.inflate(getLayoutResource(), frameLayout, false)
		frameLayout?.addView(subView)
		view?.setBackgroundColor(Color.WHITE)
		return view
	}

	override fun onActivityCreated(savedInstanceState: Bundle?)
	{
		super.onActivityCreated(savedInstanceState)
		view?.findViewById<TextView>(R.id.header_title)?.text = getTitle()
		val closeBtn = view?.findViewById<ImageButton>(R.id.header_close)
		if (isCancelable)
		{
			closeBtn?.setOnClickListener({ dismiss() })
		}
		else
		{
			closeBtn?.visibility = View.INVISIBLE
		}
		onInnerViewCreated()
	}

	override fun onDestroyView()
	{
		val dialog = dialog
		// handles https://code.google.com/p/android/issues/detail?id=17423
		if (dialog != null && retainInstance)
		{
			dialog.setDismissMessage(null)
		}
		super.onDestroyView()
	}

	override fun onSaveInstanceState(outState: Bundle)
	{
		// Fix for https://stackoverflow.com/questions/7575921/illegalstateexception-can-not-perform-this-action-after-onsaveinstancestate-wit
		outState.putString("WORKAROUND_FOR_BUG_19917_KEY", "WORKAROUND_FOR_BUG_19917_VALUE")
		super.onSaveInstanceState(outState)
	}

	override fun dismiss()
	{
		hideKeyboard()
		super.dismiss()
	}

	override fun onKey(p0: View?, p1: Int, p2: KeyEvent?): Boolean
	{
		if (p1 == KeyEvent.KEYCODE_ENTER)
		{
			hideKeyboard()
			return true
		}
		return false
	}

	protected fun hideKeyboard()
	{
		val view = view
		if (view != null)
		{
			val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
			imm.hideSoftInputFromWindow(view.windowToken, 0)
		}
	}

	fun show(transaction: FragmentTransaction?): Int = super.show(transaction, null)

	@LayoutRes protected abstract fun getLayoutResource(): Int
	protected abstract fun onInnerViewCreated()
	protected abstract fun getTitle(): String
}
