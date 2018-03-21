package com.lush.view.holder

import android.view.View

abstract class BaseSelectableViewHolder<in T>(view: View) : BaseViewHolder<T>(view)
{
	abstract fun setSelected(selected: Boolean)
}