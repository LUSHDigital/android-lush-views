package com.lush.lib.factory;

import com.lush.app.R;
import com.lush.lib.image.CloudinaryImage;

/**
 * Factory class for getting images from media objects.
 *
 * @author Matt Allen
 */
public abstract class MediaFactory
{
	public static String[] getProductImageArray(String cloudinaryUrl)
	{
		return getProductImageArray(cloudinaryUrl, CloudinaryImage.MEDIUM);
	}

	/**
	 * Because of the universal image loader system, we can specify fallbacks for images.
	 * The product image can be 3 possibilities:
	 * <ul>
	 *     <li>Reduced-size image</li>
	 *     <li>Original image</li>
	 *     <li>'Image not available' fallback</li>
	 * </ul>
	 *
	 * Use this method to obtain these image references for use in the image loader.
	 *
	 * @param cloudinaryUrl The path to the image
	 * @param size The reduced-size version can be of variable size
	 * @return String array that can be passed directly to the image loader
	 */
	public static String[] getProductImageArray(String cloudinaryUrl, @CloudinaryImage.Size int size)
	{
		String[] images = new String[3];
		images[0] = new CloudinaryImage(cloudinaryUrl, size, CloudinaryImage.WIDTH).createUrl();
		images[1] = cloudinaryUrl;
		images[2] = "drawable://" + R.drawable.ic_image_not_available;
		return images;
	}

	public static String[] getArticleImageArray(String cloudinaryUrl)
	{
		return getArticleImageArray(cloudinaryUrl, CloudinaryImage.MEDIUM);
	}

	public static String[] getArticleImageArray(String cloudinaryUrl, @CloudinaryImage.Size int size)
	{
		String[] images = new String[3];
		images[0] = new CloudinaryImage(cloudinaryUrl, size, CloudinaryImage.WIDTH).createUrl();
		images[1] = cloudinaryUrl;
		images[2] = "drawable://" + R.drawable.bg_article_no_image;
		return images;
	}
}
