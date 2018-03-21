package com.lush.lib.adapter

import com.lush.lib.listener.OnListItemClickListener
import com.lush.view.holder.BaseSelectableViewHolder
import com.lush.view.holder.BaseViewHolder
import java.util.*

/**
 * An extension over the [BaseListAdapter] which allows for items in the list to be
 * marked as selected. This is particularly useful in a situation for selecting multiple things.
 */
abstract class BaseSelectableListAdapter<T>(items: ArrayList<T> = arrayListOf(), listener: OnListItemClickListener<T>? = null) : BaseListAdapter<T>(items, listener)
{
	private var selected: ArrayList<T> = arrayListOf()

	override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int)
	{
		super.onBindViewHolder(holder, position)

		if (holder is BaseSelectableViewHolder<*>)
		{
			val item = getItem(position)
			(holder as BaseSelectableViewHolder<*>).setSelected(getSelected().contains(item))
		}
	}

	fun getSelected(): ArrayList<T> = selected

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
