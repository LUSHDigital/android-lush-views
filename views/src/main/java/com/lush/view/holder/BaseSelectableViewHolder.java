package com.lush.view.holder;

import android.view.View;

/**
 * @author Matt Allen
 */
public abstract class BaseSelectableViewHolder<T> extends BaseViewHolder<T>
{
	public BaseSelectableViewHolder(View view)
	{
		super(view);
	}

	public abstract void setSelected(boolean selected);
}
