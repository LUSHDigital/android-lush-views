package com.lush.lib.adapter.spinner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lush.view.R;

import java.util.List;
import java.util.Locale;

/**
 * @author Matt Allen
 */
public class LanguageSpinnerAdapter extends BaseSpinnerAdapter<Locale>
{
	public LanguageSpinnerAdapter(Context context, List<Locale> objects)
	{
		super(context, R.layout.view_spinner_text_item, objects);
	}

	@Override
	protected View getItemView(Locale item, View convertView, ViewGroup parent)
	{
		TextView name = (TextView) convertView.findViewById(R.id.name);
		name.setText(item.getDisplayLanguage(item));
		return convertView;
	}
}
