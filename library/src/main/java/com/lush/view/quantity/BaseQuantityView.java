package com.lush.view.quantity;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Matt Allen
 */
public abstract class BaseQuantityView extends FrameLayout
{
	private static final String TAG = BaseQuantityView.class.getSimpleName();

	private int quantity = 1, max = 30;
	private List<QuantityUpdateListener> listeners = new ArrayList<>();

	public BaseQuantityView(Context context)
	{
		super(context);
		createView();
		updateQuantity();
	}

	public BaseQuantityView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		createView();
		updateQuantity();
	}

	public BaseQuantityView(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
		createView();
		updateQuantity();
	}

	public void setMaximum(int maximum)
	{
		this.max = maximum;
	}

	public int getMaximum()
	{
		return max;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		if (quantity > 0 && quantity <= max)
		{
			this.quantity = quantity;
			updateQuantity();
		}
	}

	public void increase()
	{
		if (quantity < max)
		{
			quantity++;
			updateQuantity();
		}
		else
		{
			Log.d(TAG, "Maximum quantity reached");
		}
	}

	public void decrease()
	{
		if (quantity > 1)
		{
			quantity--;
			updateQuantity();
		}
		else
		{
			Log.d(TAG, "Cannot set quantity below 0");
		}
	}

	protected abstract void updateQuantity();
	protected abstract void createView();

	public void addQuantityUpdateListener(QuantityUpdateListener listener)
	{
		if (listeners == null)
		{
			listeners = new ArrayList<>();
		}
		if (!listeners.contains(listener))
		{
			listeners.add(listener);
		}
	}

	public void removeQuantityUpdateListener(QuantityUpdateListener listener)
	{
		if (listeners != null && listeners.size() > 0 && listeners.contains(listener))
		{
			listeners.remove(listener);
		}
	}

	/**
	 * Trigger any of the listeners registered with View instance.
	 */
	protected void updateListeners()
	{
		if (listeners != null && listeners.size() > 0)
		{
			for (QuantityUpdateListener listener : listeners)
			{
				if (listener != null)
				{
					listener.onQuantityChange(getQuantity());
				}
			}
		}
	}
}
