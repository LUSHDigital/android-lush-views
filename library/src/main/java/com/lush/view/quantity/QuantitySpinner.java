package com.lush.view.quantity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.lush.view.R;

/**
 * Spinner that shows numbers 1 - 30 for the user to select a quantity of products to purchase.
 *
 * @author Matt Allen
 */
public class QuantitySpinner extends BaseQuantityView implements AdapterView.OnItemSelectedListener
{
	private Spinner spinner;

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
		spinner = (Spinner) view.findViewById(R.id.spinner);
		createAdapter();
		spinner.setOnItemSelectedListener(this);
	}

	private void createAdapter()
	{
		int max = getMaximum();
		String[] strings = new String[getMaximum()];
		for (int i = 0; i < max; i++)
		{
			strings[i] = String.valueOf(i + 1);
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.view_spinner_text_item, R.id.name, strings);
		spinner.setAdapter(adapter);
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
