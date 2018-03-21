package com.lush.lib.listener

import android.view.View

interface OnListItemClickListener<in T>
{
	fun onItemClick(item: T, view: View)
}