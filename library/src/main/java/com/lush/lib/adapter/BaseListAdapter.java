package com.lush.lib.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lush.lib.listener.OnListItemClickListener;
import com.lush.view.holder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Matt Allen
 */
public abstract class BaseListAdapter<T> extends RecyclerView.Adapter<BaseViewHolder<T>>
{
	private List<T> mItems;
	private OnListItemClickListener<T> mListener;

	public BaseListAdapter(List<T> items, OnListItemClickListener<T> listener)
	{
		setItems(items);
		mListener = listener;
	}

	@Override
	public int getItemCount()
	{
		return mItems != null ? mItems.size() : 0;
	}

	public T getItem(int position)
	{
		return mItems != null ? mItems.get(position) : null;
	}

	public void setItems(List<T> items)
	{
		if (items != null)
		{
			mItems = new ArrayList<>(items);
			notifyDataSetChanged();
		}
	}

	public List<T> getItems()
	{
		if (mItems == null)
		{
			mItems = new ArrayList<>();
		}
		return mItems;
	}

	public void addItem(T item)
	{
		if (mItems == null)
		{
			mItems = new ArrayList<>();
		}
		mItems.add(item);
		notifyItemInserted(mItems.indexOf(item));
	}

	public void removeItem(T item)
	{
		if (mItems != null)
		{
			notifyItemRemoved(mItems.indexOf(item));
			mItems.remove(item);
		}
	}

	public T removeItem(int position)
	{
		if (mItems != null)
		{
			T item = mItems.remove(position);
			notifyItemRemoved(position);
			return item;
		}
		return null;
	}

	public void addItem(int position, T item)
	{
		getItems().add(position, item);
		notifyItemInserted(position);
	}

	public void moveItem(int fromPosition, int toPosition)
	{
		if (mItems != null)
		{
			T item = mItems.remove(fromPosition);
			mItems.add(toPosition, item);
			notifyItemMoved(fromPosition, toPosition);
		}
	}

	protected OnListItemClickListener<T> getListener()
	{
		return mListener;
	}

	protected int getPosition(T item)
	{
		if (mItems != null && mItems.size() > 0)
		{
			return mItems.indexOf(item);
		}
		return -1;
	}

	public void setItemsWithAnimation(List<T> items)
	{
		applyAndAnimateRemovals(items);
		applyAndAnimateAdditions(items);
		applyAndAnimateMovedItems(items);
	}

	private void applyAndAnimateRemovals(List<T> newItems)
	{
		for (int i = getItems().size() - 1; i >= 0; i--)
		{
			T item = getItems().get(i);
			if (!newItems.contains(item))
			{
				removeItem(i);
			}
		}
	}

	private void applyAndAnimateAdditions(List<T> newItems)
	{
		for (int i = 0, count = newItems.size(); i < count; i++)
		{
			T item = newItems.get(i);
			if (!getItems().contains(item))
			{
				addItem(i, item);
			}
		}
	}

	private void applyAndAnimateMovedItems(List<T> newItems)
	{
		for (int toPosition = newItems.size() - 1; toPosition >= 0; toPosition--)
		{
			T model = newItems.get(toPosition);
			final int fromPosition = getItems().indexOf(model);
			if (fromPosition >= 0 && fromPosition != toPosition)
			{
				moveItem(fromPosition, toPosition);
			}
		}
	}

	public void setListener(OnListItemClickListener<T> listener)
	{
		mListener = listener;
	}

	@Override
	public void onBindViewHolder(BaseViewHolder<T> holder, int position)
	{
		final T item = getItem(position);
		holder.bind(item);
		if (mListener != null)
		{
			holder.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					mListener.onItemClick(item, v);
				}
			});
		}
	}
}
