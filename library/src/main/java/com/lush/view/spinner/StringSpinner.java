package com.lush.view.spinner;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;

import com.lush.lib.adapter.spinner.StringSpinnerAdapter;

/**
 * @author Matt Allen
 */
public class StringSpinner extends BaseLushSpinner<String>
{
	public StringSpinner(Context context)
	{
		super(context);
	}

	public StringSpinner(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	public StringSpinner(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected ArrayAdapter<String> createAdapter()
	{
		return new StringSpinnerAdapter(getContext(), getItems());
	}
}
