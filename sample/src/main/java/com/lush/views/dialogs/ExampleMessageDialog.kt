package com.lush.views.dialogs

import com.lush.dialog.BaseSimpleMessageDialog

class ExampleMessageDialog: BaseSimpleMessageDialog()
{
	override fun getMessage(): String = "The message for the user will go here"
	override fun getTitle(): String = "Example"
}