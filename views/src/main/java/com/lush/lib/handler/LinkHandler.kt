package com.lush.lib.handler

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * Handler class to handle telephone, navigation and e-mail links
 *
 * @author Gokhan
 */
object LinkHandler
{
	fun handleLink(context: Context, urlString: String?): Boolean
	{
		if (urlString != null)
		{
			when
			{
				urlString.startsWith("tel:")    ->
				{
					val intent = Intent(Intent.ACTION_DIAL, Uri.parse(urlString))
					attemptStartActivity(context, intent)
					return true
				}
				urlString.startsWith("mailto:") ->
				{
					val url = urlString.substring(7)
					val mail = Intent(Intent.ACTION_SEND)
					mail.type = "message/rfc822"
					mail.putExtra(Intent.EXTRA_EMAIL, arrayOf(url))
					mail.putExtra(Intent.EXTRA_SUBJECT, "")
					mail.putExtra(Intent.EXTRA_TEXT, "")
					attemptStartActivity(context, mail)
					return true
				}
				urlString.startsWith("map:")    ->
				{
					val url = urlString.substring(4)
					val map = "http://maps.google.com/maps?q=" + url
					val intent = Intent(Intent.ACTION_VIEW, Uri.parse(map))
					attemptStartActivity(context, intent)
					return true
				}
				else                            ->
				{
				}
			}
		}
		return false
	}

	private fun attemptStartActivity(context: Context, mail: Intent)
	{
		try
		{
			context.startActivity(mail)
		}
		catch (e: ActivityNotFoundException)
		{
			// Do nothing if no associated apps present on device
		}

	}
}
