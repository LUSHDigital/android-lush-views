package com.lush.lib.listener;

import com.lush.view.spinner.BaseLushSpinner;

/**
 * To be used with the {@link com.lush.view.spinner.BaseLushSpinner} implementations.
 *
 * @author Matt Allen
 */
public interface OnItemSelectedListener<T>
{
	void onItemSelected(BaseLushSpinner<T> view, T item);
}
