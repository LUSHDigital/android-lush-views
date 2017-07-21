package com.lush.lib.adapter.spinner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lush.view.R;

import java.util.List;

/**
 * @author Matt Allen
 */
public class StringSpinnerAdapter extends BaseSpinnerAdapter<String>
{
	public StringSpinnerAdapter(Context context, List<String> objects)
	{
		super(context, R.layout.view_spinner_text_item, objects);
	}

	@Override
	protected View getItemView(String item, View convertView, ViewGroup parent)
	{
		TextView name = (TextView) convertView.findViewById(R.id.name);
		name.setText(item);
		return convertView;
	}
}
