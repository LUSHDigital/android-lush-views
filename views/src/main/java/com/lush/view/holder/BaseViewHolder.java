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

	/**
	 * Override this method to cancel any behaviour you don't want to continue after the view has been recycled
	 * This is most likely async behaviour
	 */
	public void recycle()
	{

	}
}