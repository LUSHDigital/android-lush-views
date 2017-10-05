package com.lush.view.quantity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.lush.view.R;

import java.util.ArrayList;

/**
 * Spinner that shows numbers 1 - 30 for the user to select a quantity of products to purchase.
 *
 * @author Matt Allen
 */
public class QuantitySpinner extends BaseQuantityView implements AdapterView.OnItemSelectedListener
{
	private Spinner spinner;
	private ArrayAdapter<String> adapter;

	public QuantitySpinner(Context context)
	{
		super(context);
	}

	public QuantitySpinner(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	public QuantitySpinner(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected void updateQuantity()
	{
		spinner.setSelection(getQuantity() - 1);
	}

	@Override
	protected void createView()
	{
		View view = inflate(getContext(), R.layout.view_quantity_spinner, this);
		spinner = view.findViewById(R.id.spinner);
		createAdapter();
		spinner.setOnItemSelectedListener(this);
	}

	private void createAdapter()
	{
		int max = getMaximum();
		ArrayList<String> strings = new ArrayList<>();
		for (int i = 0; i < max; i++)
		{
			strings.add(String.valueOf(i + 1));
		}
		adapter = new ArrayAdapter<>(getContext(), R.layout.view_spinner_text_item, R.id.name, strings);
		spinner.setAdapter(adapter);
	}

	@Override
	protected void updateAdapter()
	{
		if (spinner != null && adapter != null)
		{
			adapter.clear();
			for (int i = 0; i < getMaximum(); i++)
			{
				adapter.insert(String.valueOf(i + 1), adapter.getCount());
			}
			adapter.notifyDataSetChanged();
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
	{
		if (getQuantity() == (i + 1))
		{
			setQuantity(i + 1);
		}
		else
		{
			setQuantity(i + 1);
			updateListeners();
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> adapterView)
	{
		setQuantity(1);
		updateListeners();
	}
}
