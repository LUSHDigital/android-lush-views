package com.lush.views.dialogs

import android.os.Message
import com.lush.dialog.BaseStatusDialog
import java.util.*
import kotlin.concurrent.timerTask

class StatusFailureDialog: BaseStatusDialog(), android.os.Handler.Callback
{
	override fun startTask()
	{
		val handler = android.os.Handler(this)
		Timer().schedule(timerTask { handler.sendEmptyMessage(0) }, 5000)
	}

	override fun handleMessage(p0: Message?): Boolean
	{
		taskFailed("Task failed to complete")
		return true
	}

	override fun isStoppable(): Boolean = false
	override fun getTitle(): String = "Failure status"
	override fun getLoadingMessage(): String = "Doing something for the user"
}