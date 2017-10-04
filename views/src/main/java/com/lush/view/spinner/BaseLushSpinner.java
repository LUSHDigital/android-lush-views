package com.lush.view.spinner;

import android.content.Context;
import android.support.v7.widget.AppCompatSpinner;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.lush.view.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class to use for spinners to create the look and feel
 * to match to the Lush design guidelines.
 *
 * @author Matt Allen
 */
public abstract class BaseLushSpinner<T> extends AppCompatSpinner implements AdapterView.OnItemSelectedListener
{
	private List<T> items = new ArrayList<>();
	private List<com.lush.lib.listener.OnItemSelectedListener<T>> listeners;

	public BaseLushSpinner(Context context)
	{
		super(context);
		init();
	}

	public BaseLushSpinner(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		init();
	}

	public BaseLushSpinner(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
		init();
	}

	private void init()
	{
		applyStyle();
		setOnItemSelectedListener(this);
	}

	public List<T> getItems()
	{
		return items;
	}

	public void setItems(List<T> items)
	{
		this.items = items;
		if (this.items == null)
		{
			this.items = new ArrayList<>();
		}
		updateAdapter();
	}

	public void setSelection(T selection)
	{
		for (int i = 0, count = getItems().size(); i < count; i++)
		{
			T item = getItems().get(i);
			if (item instanceof String)
			{
				if (item.equals(selection))
				{
					setSelection(i);
					return;
				}
			}
			else
			{
				if (item == selection)
				{
					setSelection(i);
					return;
				}
			}
		}
	}

	private void updateAdapter()
	{
		setAdapter(createAdapter());
	}

	protected abstract ArrayAdapter<T> createAdapter();

	private void applyStyle()
	{
		setBackgroundResource(R.drawable.bg_outline_light_grey);
	}

	public T getSelected()
	{
		try
		{
			return (T) getAdapter().getItem(getSelectedItemPosition());
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			return null;
		}
	}

	public void addOnItemSelectedListener(com.lush.lib.listener.OnItemSelectedListener<T> listener)
	{
		if (listeners == null)
		{
			listeners = new ArrayList<>(1);
		}
		listeners.add(listener);
	}

	public void removeOnItemSelectedListener(com.lush.lib.listener.OnItemSelectedListener<T> listener)
	{
		if (listeners != null)
		{
			listeners.remove(listener);
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
	{
		if (listeners != null && listeners.size() > 0)
		{
			for (com.lush.lib.listener.OnItemSelectedListener<T> listener : listeners)
			{
				listener.onItemSelected(this, getItems() != null ? getItems().get(position) : null);
			}
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent)
	{
		if (listeners != null && listeners.size() > 0)
		{
			for (com.lush.lib.listener.OnItemSelectedListener<T> listener : listeners)
			{
				listener.onItemSelected(this, null);
			}
		}
	}
}
