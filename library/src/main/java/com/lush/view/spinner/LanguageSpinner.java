package com.lush.view.spinner;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;

import com.lush.lib.adapter.spinner.LanguageSpinnerAdapter;

import java.util.Locale;

/**
 * Display a list of languages for the user to select from.
 *
 * @author Matt Allen
 */
public class LanguageSpinner extends BaseLushSpinner<Locale>
{
	public LanguageSpinner(Context context)
	{
		super(context);
	}

	public LanguageSpinner(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	public LanguageSpinner(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected ArrayAdapter<Locale> createAdapter()
	{
		return new LanguageSpinnerAdapter(getContext(), getItems());
	}
}
