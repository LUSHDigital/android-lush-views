package com.lush.views.dialogs

import android.os.Handler
import android.os.Message
import com.lush.dialog.BaseStatusDialog
import java.util.*
import kotlin.concurrent.timerTask

class StatusSuccessDialog: BaseStatusDialog(), Handler.Callback
{
	override fun startTask()
	{
		val handler = android.os.Handler(this)
		Timer().schedule(timerTask { handler.sendEmptyMessage(0) }, 5000)
	}

	override fun handleMessage(p0: Message?): Boolean
	{
		taskComplete("Task completed successfully")
		return true
	}

	override fun isStoppable(): Boolean = false
	override fun getTitle(): String = "Success status"
	override fun getLoadingMessage(): String = "Doing something for the user"
}