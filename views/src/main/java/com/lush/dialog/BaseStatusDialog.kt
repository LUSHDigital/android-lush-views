package com.lush.dialog

import android.view.View
import android.widget.TextView
import com.lush.view.R

/**
 * Implementation of BaseDialog that exposes the ability to present a loading interface
 * inside a dialog to the user with possible finishing states of failure or success.
 *
 * It's the responsibility of the concrete implementation to call either taskComplete()
 * or taskFailed() passing the error or success message for the lifecycle of this
 * dialog to complete.
 */
abstract class BaseStatusDialog: BaseDialog()
{
	private val loading: View? by lazy { view?.findViewById<View>(R.id.loading) }
	private val finished: View? by lazy { view?.findViewById<View>(R.id.finished) }

	override fun onInnerViewCreated()
	{
		view?.findViewById<View>(R.id.close)?.setOnClickListener({ dismiss() })
		showView(loading)
		val loadingMessage = getLoadingMessage()
		if (loadingMessage.isNotBlank())
		{
			view?.findViewById<TextView>(R.id.loading_text)?.text = loadingMessage
		}
		else
		{
			view?.findViewById<TextView>(R.id.loading_text)?.visibility = View.GONE
		}
		startTask()
	}

	protected fun taskComplete(message: String)
	{
		try
		{
			showView(finished)
			view?.findViewById<TextView>(R.id.text)?.text = message
		}
		catch (e: Exception)
		{
			e.printStackTrace()
		}
	}

	protected fun taskFailed(message: String)
	{
		try
		{
			showView(finished)
			view?.findViewById<TextView>(R.id.text)?.text = message
		}
		catch (e: Exception)
		{
			e.printStackTrace()
		}
	}

	private fun showView(view: View?)
	{
		finished?.visibility = if (view == finished) View.VISIBLE else View.GONE
		loading?.visibility = if (view == loading) View.VISIBLE else View.GONE
	}

	override fun isCancelable(): Boolean = isStoppable()
	override fun getLayoutResource(): Int = R.layout.dialog_status

	abstract fun startTask()
	abstract fun isStoppable(): Boolean
	abstract fun getLoadingMessage(): String
}