package com.lush.lib.adapter.spinner;

import android.content.Context;
import android.text.TextUtils;
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
		TextView name = convertView.findViewById(R.id.name);
		if (name != null && item != null)
		{
			String language = item.getDisplayLanguage(item);
			if (item == Locale.TRADITIONAL_CHINESE)
			{
				language = convertView.getContext().getString(R.string.chinese_traditional);
			}
			else if (item == Locale.SIMPLIFIED_CHINESE)
			{
				language = convertView.getContext().getString(R.string.chinese_simplified);
			}
			else if (!TextUtils.isEmpty(language))
			{
				// Capitalize language
				language = language.substring(0, 1).toUpperCase() + language.substring(1);
			}
			name.setText(language);
		}
		return convertView;
	}
}
