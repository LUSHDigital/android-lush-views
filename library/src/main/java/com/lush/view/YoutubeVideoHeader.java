package com.lush.view;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.yqritc.scalablevideoview.ScalableVideoView;

import java.io.IOException;

/**
 * Product pages show a image header before transitioning into a YouTube video.
 *
 * This view adheres to the following variables:
 * <ul>
 *     <li>Transition time (Between image and video)</li>
 *     <li>Header image URL</li>
 *     <li>YouTube video URL</li>
 *     <li>Overlay text</li>
 * </ul>
 *
 * @author Matt Allen
 */
public class YoutubeVideoHeader extends FrameLayout
{
	private static final String TAG = YoutubeVideoHeader.class.getSimpleName();

	protected ScalableVideoView videoView;
	protected ImageView imageView;
	protected TextView title, subtitle;
	private String videoUrl, imageUrl, titleText, subtitleText;

	public YoutubeVideoHeader(Context context)
	{
		super(context);
		init();
	}

	public YoutubeVideoHeader(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		init();
	}

	public YoutubeVideoHeader(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
		init();
	}

	private void init()
	{
		View view = inflate(getContext(), R.layout.view_video_header, this);
		videoView = (ScalableVideoView) view.findViewById(R.id.video);
		imageView = (ImageView) view.findViewById(R.id.image);
		title = (TextView) view.findViewById(R.id.title);
		subtitle = (TextView) view.findViewById(R.id.subtitle);
	}

	private void playVideo() throws IOException
	{
		if (!TextUtils.isEmpty(videoUrl))
		{
			videoView.setDataSource(getContext(), Uri.parse(videoUrl));
			videoView.setLooping(true);
			videoView.setClickable(false);
			videoView.prepareAsync(new MediaPlayer.OnPreparedListener()
			{
				@Override
				public void onPrepared(MediaPlayer mp)
				{
					videoView.start();
				}
			});
		}
		else
		{
			Log.e(TAG, "No video URL supplied. Not starting video.");
		}
	}

	public String getVideoUrl()
	{
		return videoUrl;
	}

	public String getImageUrl()
	{
		return imageUrl;
	}

	public String getTitle()
	{
		return titleText;
	}

	public String getSubtitle()
	{
		return subtitleText;
	}

	public void setTitle(String text)
	{
		titleText = text;
		title.setText(text);
		title.setVisibility(TextUtils.isEmpty(text) ? View.GONE : View.VISIBLE);
	}

	public void setSubtitle(String text)
	{
		subtitleText = text;
		subtitle.setText(text);
		subtitle.setVisibility(TextUtils.isEmpty(text) ? View.GONE : View.VISIBLE);
	}

	public void setImageUrl(String imageUrl)
	{
		this.imageUrl = imageUrl;
		if (!TextUtils.isEmpty(imageUrl))
		{
			ImageLoader.getInstance().displayImage(imageUrl, imageView);
		}
	}

	public void setVideoUrl(String videoUrl)
	{
		this.videoUrl = videoUrl;
		try
		{
			playVideo();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
