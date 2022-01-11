package com.lush;

import android.app.Application;
import android.graphics.Bitmap;

import com.lush.lib.handler.CloudinarySchemeHandler;
import com.lush.view.R;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;

/**
 * There's a certain amount of stuff that needs to happen to make the
 * whole application look and act in the way we want it to.
 *
 * @author Matt Allen
 */
public abstract class LushApplication extends Application
{
	@Override
	public void onCreate()
	{
		super.onCreate();
		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.cacheInMemory(false)
				.cacheOnDisk(true)
				.resetViewBeforeLoading(true)
				.bitmapConfig(Bitmap.Config.RGB_565)
				.imageScaleType(ImageScaleType.IN_SAMPLE_INT)
				.build();

		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
				.defaultDisplayImageOptions(options)
				.memoryCache(new WeakMemoryCache())
				.build();

		ImageLoader.getInstance().init(config);
		ImageLoader.getInstance().registerSchemeHandler("cloudinary", new CloudinarySchemeHandler());

		ViewPump.init(ViewPump.builder()
				.addInterceptor(new CalligraphyInterceptor(
						new CalligraphyConfig.Builder()
								.setDefaultFontPath("fonts/HelveticaNeueLTPro-Roman.otf")
								.setFontAttrId(R.attr.fontPath)
								.build()))
				.build());
	}
}
