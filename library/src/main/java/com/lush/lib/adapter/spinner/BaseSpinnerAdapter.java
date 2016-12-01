package com.lush.lib.adapter.spinner;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * @author Matt Allen
 */
public abstract class BaseSpinnerAdapter<T> extends ArrayAdapter<T>
{
	@LayoutRes protected int layoutResource;

	public BaseSpinnerAdapter(Context context, int resource, List<T> objects)
	{
		super(context, resource, objects);
		layoutResource = resource;
	}

	@NonNull @Override
	public View getView(int position, View convertView, @NonNull ViewGroup parent)
	{
		T item = getItem(position);
		if (convertView == null)
		{
			LayoutInflater inflater = LayoutInflater.from(getContext());
			convertView = inflater.inflate(layoutResource, parent, false);
		}
		return getItemView(item, convertView, parent);
	}

	@Override
	public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent)
	{
		T item = getItem(position);
		if (convertView == null)
		{
			LayoutInflater inflater = LayoutInflater.from(getContext());
			convertView = inflater.inflate(layoutResource, parent, false);
		}
		return getItemView(item, convertView, parent);
	}

	/**
	 * Update the already-inflated View to represent the item currently being shown.
	 *
	 * @param item The item to reflect in the View.
	 * @param convertView The already-inflated View.
	 * @param parent The parent ViewGroup that the View will be shown in.
	 * @return The updated View to show in the Spinner.
	 */
	protected abstract View getItemView(T item, View convertView, ViewGroup parent);
}
