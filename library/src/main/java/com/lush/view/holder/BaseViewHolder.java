package com.lush.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Base class for all view holders to be used in concrete implementations of {@link com.lush.lib.adapter.BaseListAdapter}
 *
 * @author Matt Allen
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder
{
	public BaseViewHolder(View view)
	{
		super(view);
	}

	public abstract void bind(T model);

	public void setOnClickListener(View.OnClickListener listener)
	{
		itemView.setOnClickListener(listener);
	}
}
