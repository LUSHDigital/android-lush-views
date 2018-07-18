package com.lush.view.holder

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.View
import com.lush.view.R

/**
 * Base class for all view holders to be used in concrete implementations of [com.lush.lib.adapter.BaseListAdapter]
 */
abstract class BaseViewHolder<in T>(view: View?) : RecyclerView.ViewHolder(view)
{
	abstract fun bind(model: T)

	fun setOnClickListener(listener: View.OnClickListener)
	{
		itemView?.setOnClickListener(listener)
	}

	fun setPositionInList(position: Int)
	{
		itemView?.setBackgroundColor(if ((position % 2) == 0) Color.WHITE else itemView.resources.getColor(R.color.list_item_alternate))
	}

	/**
	 * Override this method to cancel any behaviour you don't want to continue after the view has been recycled
	 * This is most likely async behaviour
	 */
	open fun recycle() { }
}