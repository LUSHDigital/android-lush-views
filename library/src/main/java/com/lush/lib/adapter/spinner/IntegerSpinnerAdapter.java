package com.lush.lib.adapter.spinner;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lush.view.R;

import java.util.List;

/**
 * @author Matt Allen
 */
public class IntegerSpinnerAdapter extends BaseSpinnerAdapter<Integer>
{
	private String zeroText;

	public IntegerSpinnerAdapter(Context context, List<Integer> objects, String zeroText)
	{
		super(context, R.layout.view_spinner_text_item, objects);
		this.zeroText = zeroText;
	}

	public void setZeroText(String zeroText)
	{
		this.zeroText = zeroText;
	}

	@Override
	protected View getItemView(Integer item, View convertView, ViewGroup parent)
	{
		TextView text = (TextView) convertView.findViewById(R.id.name);
		if (item == 0 && !TextUtils.isEmpty(zeroText))
		{
			text.setText(zeroText);
		}
		else
		{
			text.setText(String.valueOf(item));
		}
		return convertView;
	}
}
