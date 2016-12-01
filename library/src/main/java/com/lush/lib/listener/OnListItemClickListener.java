package com.lush.lib.listener;

import android.view.View;

/**
 * @author Matt Allen
 */
public interface OnListItemClickListener<T>
{
	void onItemClick(T item, View view);
}
