package com.lush.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lush.view.R;

/**
 * @author Matt Allen, Gokhan
 */
public class WebViewFragment extends Fragment
{
	private static final String KEY_URL = "key_url";
	private WebView mWebView;
	private ViewGroup mLoading;

	private String mUrl;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_webview, container, false);
		mWebView = (WebView) view.findViewById(R.id.webview);
		mLoading = (ViewGroup) view.findViewById(R.id.loading);
		return view;
	}

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		mUrl = (savedInstanceState != null ? savedInstanceState.getString(KEY_URL) : mUrl);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.setWebViewClient(new WebViewClient()
		{
			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon)
			{
				super.onPageStarted(view, url, favicon);
				setLoading(true);
			}

			@Override
			public void onPageFinished(WebView view, String url)
			{
				super.onPageFinished(view, url);
				setLoading(false);
			}
		});
		mWebView.loadUrl(mUrl);
	}

	@Override
	public void onSaveInstanceState(Bundle outState)
	{
		outState.putString(KEY_URL, mUrl);
		super.onSaveInstanceState(outState);
	}


	private void setLoading(boolean loading)
	{
		if (getView() == null)
		{
			return;
		}

		if (loading)
		{
			int newY = getView().getHeight() - mLoading.getHeight();
			mLoading.animate()
					.setDuration(500)
					.setInterpolator(new FastOutSlowInInterpolator())
					.y(newY)
					.start();
		}
		else
		{
			mLoading.animate()
					.setDuration(500)
					.setInterpolator(new FastOutSlowInInterpolator())
					.y(getView().getHeight())
					.start();
		}
	}

	public static WebViewFragment instantiate(String url)
	{
		WebViewFragment frag = new WebViewFragment();
		frag.setUrl(url);
		return frag;
	}

	public void setUrl(String url)
	{
		mUrl = url;
	}
}
