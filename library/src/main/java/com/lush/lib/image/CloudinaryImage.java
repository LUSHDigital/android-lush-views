package com.lush.lib.image;

import android.support.annotation.IntDef;
import android.support.annotation.StringDef;

import com.nostra13.universalimageloader.image.ImageServiceOptions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Matt Allen
 */
public class CloudinaryImage implements ImageServiceOptions
{
	private static final String BASE_URL = "https://res.cloudinary.com/lush/image/upload/";

	@Retention(RetentionPolicy.SOURCE)
	@StringDef({HEIGHT, WIDTH})
	public @interface Orientation{}
	public static final String HEIGHT = "h";
	public static final String WIDTH = "w";

	@Retention(RetentionPolicy.SOURCE)
	@IntDef({SMALL, MEDIUM, LARGE})
	public @interface Size{}
	public static final int SMALL = 150;
	public static final int MEDIUM = 300;
	public static final int LARGE = 400;

	private String id, orientation;
	private int size;

	public CloudinaryImage()
	{
	}

	public CloudinaryImage(String imageUrl)
	{
		this(imageUrl, MEDIUM, WIDTH);
	}

	public CloudinaryImage(String id, @Size int size, @Orientation String orientation)
	{
		this.id = id != null ? id.replace("\\", "") : "";
		this.size = size;
		this.orientation = orientation;
	}

	public String getImageUrl()
	{
		return BASE_URL + id;
	}

	@Orientation
	public String getOrientation()
	{
		return orientation;
	}

	@Size
	public int getSize()
	{
		return size;
	}

	@Override
	public String createUrl()
	{
		return "cloudinary://" + id + ";" + size + ";" + orientation;
	}

	@Override
	public void fromUrl(String url)
	{
		String[] parts = url.split(";");
		id = parts[0].substring("cloudinary://".length());
		size = Integer.valueOf(parts[1]);
		orientation = parts[2];
	}
}
