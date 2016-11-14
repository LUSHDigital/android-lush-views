package com.lush.view.quantity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lush.view.R;

/**
 * When adding a product to the basket, the quantity should be managed by this view.
 *
 * @author Matt Allen
 */
public class QuantityView extends BaseQuantityView implements View.OnClickListener
{
	private ImageView plus, minus;
	private TextView number;

	public QuantityView(Context context)
	{
		super(context);
	}

	public QuantityView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	public QuantityView(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
	}

	protected void createView()
	{
		View view = inflate(getContext(), R.layout.view_quantity, this);
		plus = (ImageView) view.findViewById(R.id.plus);
		minus = (ImageView) view.findViewById(R.id.minus);
		number = (TextView) view.findViewById(R.id.number);
		plus.setOnClickListener(this);
		minus.setOnClickListener(this);
	}

	@Override
	public void onClick(View view)
	{
		if (view.getId() == plus.getId())
		{
			increase();
			updateListeners();
		}
		else if (view.getId() == minus.getId())
		{
			decrease();
			updateListeners();
		}
	}

	@Override
	protected void updateQuantity()
	{
		number.setText(String.valueOf(getQuantity()));
	}
}
