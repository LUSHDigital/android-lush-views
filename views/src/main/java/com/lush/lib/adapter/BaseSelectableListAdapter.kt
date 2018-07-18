package com.lush.lib.adapter

import com.lush.lib.listener.OnListItemClickListener
import com.lush.view.holder.BaseSelectableViewHolder
import com.lush.view.holder.BaseViewHolder

/**
 * An extension over the [BaseListAdapter] which allows for items in the list to be
 * marked as selected. This is particularly useful in a situation for selecting multiple things.
 */
abstract class BaseSelectableListAdapter<T>(
		items: List<T> = ArrayList(),
		listener: OnListItemClickListener<T>? = null,
		colourAlternateItems: Boolean = false
): BaseListAdapter<T>(items, listener, colourAlternateItems)
{
	private val selected: ArrayList<T> = ArrayList()

	constructor(items: List<T> = ArrayList(), listener: OnListItemClickListener<T>? = null): this(items, listener, false)

	override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int)
	{
		super.onBindViewHolder(holder, position)

		if (holder is BaseSelectableViewHolder<*>)
		{
			val item = getItem(position)
			(holder as BaseSelectableViewHolder<*>).setSelected(getSelected().contains(item))
		}
	}

	fun getSelected(): List<T> = selected

	fun addSelected(item: T)
	{
		selected.add(item)
		val position = getPosition(item)
		notifyItemChanged(position)
	}

	fun removeSelected(item: T)
	{
		selected.remove(item)
		val position = getPosition(item)
		notifyItemChanged(position)
	}

	fun setSelected(item: T)
	{
		val selectedCopy = ArrayList(selected)
		for (toRemove in selectedCopy)
		{
			removeSelected(toRemove)
		}
		addSelected(item)
	}
}
