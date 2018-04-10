package com.lush.view.holder

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Base class for all view holders to be used in concrete implementations of [com.lush.lib.adapter.BaseListAdapter]
 */
abstract class BaseViewHolder<in T>(view: View?) : RecyclerView.ViewHolder(view)
{
	abstract fun bind(model: T)

	fun setOnClickListener(listener: (View) -> Unit)
	{
		itemView.setOnClickListener(listener)
	}

	/**
	 * Override this method to cancel any behaviour you don't want to continue after the view has been recycled
	 * This is most likely async behaviour
	 */
	fun recycle() { }
}