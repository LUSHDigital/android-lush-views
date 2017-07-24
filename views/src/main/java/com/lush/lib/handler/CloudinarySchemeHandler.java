package com.lush.lib.handler;

import android.content.Context;
import android.util.Log;

import com.lush.lib.image.CloudinaryImage;
import com.nostra13.universalimageloader.core.download.handlers.SchemeHandler;

import java.io.IOException;
import java.io.InputStream;

/**
 * Scheme handler for Cloundinary URLs. This allows for much better loading of images
 *
 * @author Matt Allen
 */
public class CloudinarySchemeHandler extends SchemeHandler
{
	private static final String TAG = CloudinarySchemeHandler.class.getSimpleName();
	@Override
	public InputStream getStreamForPath(Context context, String path, Object optionForDownloader, int connectTimeout, int readTimeout)
	{
		float densityDpi = context.getResources().getDisplayMetrics().density;
		CloudinaryImage image = new CloudinaryImage();
		image.fromUrl(path);
		int actualSize = (int) densityDpi * image.getSize();
		String[] parts = image.getImageUrl().split("upload/");
		try
		{
			String actualUrl = parts[0] + "upload/" + image.getOrientation() + "_" + String.valueOf(actualSize) + "/" + parts[1];
			return getStreamFromNetwork(actualUrl, connectTimeout, readTimeout, optionForDownloader);
		}
		catch (IOException e)
		{
			return null;
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			Log.w(TAG, "No ID for cloudinary image. Cannot download image.");
			return null;
		}
	}
}
