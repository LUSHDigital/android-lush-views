package com.lush.lib.adapter;

import com.lush.lib.listener.OnListItemClickListener;
import com.lush.view.holder.BaseSelectableViewHolder;
import com.lush.view.holder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * An extension over the {@link BaseListAdapter} which allows for items in the list to be
 * marked as selected. This is particularly useful in a situation for selecting multiple things.
 *
 * @author Matt Allen
 */
public abstract class BaseSelectableListAdapter<T> extends BaseListAdapter<T>
{
	private List<T> selected;

	public BaseSelectableListAdapter(List<T> items, OnListItemClickListener<T> listener)
	{
		super(items, listener);
	}

	@Override
	public void onBindViewHolder(BaseViewHolder<T> holder, int position)
	{
		super.onBindViewHolder(holder, position);

		if (holder instanceof BaseSelectableViewHolder)
		{
			T item = getItem(position);
			((BaseSelectableViewHolder) holder).setSelected(getSelected().contains(item));
		}
	}

	public List<T> getSelected()
	{
		if (selected == null)
		{
			selected = new ArrayList<>();
		}
		return selected;
	}

	public void addSelected(T contact)
	{
		getSelected().add(contact);
		int position = getPosition(contact);
		notifyItemChanged(position);
	}

	public void removeSelected(T contact)
	{
		getSelected().remove(contact);
		int position = getPosition(contact);
		notifyItemChanged(position);
	}
}
