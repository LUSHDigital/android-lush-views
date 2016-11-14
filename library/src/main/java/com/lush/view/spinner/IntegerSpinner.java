package com.lush.view.spinner;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;

import com.lush.lib.adapter.spinner.IntegerSpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * For displaying the month or year on the credit card entry form.
 *
 * @author Matt Allen
 */
public class IntegerSpinner extends BaseLushSpinner<Integer>
{
	private String zeroText;
	public IntegerSpinner(Context context)
	{
		super(context);
	}

	public IntegerSpinner(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	public IntegerSpinner(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
	}

	public void setZeroText(String zeroText)
	{
		this.zeroText = zeroText;
		if (getAdapter() instanceof IntegerSpinnerAdapter)
		{
			((IntegerSpinnerAdapter) getAdapter()).setZeroText(zeroText);
			((IntegerSpinnerAdapter) getAdapter()).notifyDataSetChanged();
		}
	}

	/**
	 * Create a dataset for this spinner which is between a
	 * minimum (inclusive) number and a maximum (inclusive).
	 *
	 * @param min Smallest number
	 * @param max Largest number
	 */
	public void setRange(int min, int max)
	{
		List<Integer> items = new ArrayList<>((max - min) + 1);
		for (int i = min; i <= max; i++)
		{
			items.add(i);
		}
		setItems(items);
	}

	@Override
	protected ArrayAdapter<Integer> createAdapter()
	{
		return new IntegerSpinnerAdapter(getContext(), getItems(), zeroText);
	}
}
