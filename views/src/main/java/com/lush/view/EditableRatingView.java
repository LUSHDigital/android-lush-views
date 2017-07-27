package com.lush.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Editable version of the {@link RatingView}
 *
 * @author Gokhan
 */
public class EditableRatingView extends RatingView
{

	public EditableRatingView(Context context)
	{
		super(context);
	}

	public EditableRatingView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	public EditableRatingView(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		return true;
	}

	@Override
	public boolean onTouchEvent (MotionEvent event)
	{
		if (event.getAction() == MotionEvent.ACTION_UP)
		{
			final float viewWidth = getWidth();
			final float touchedCoordinate = event.getX();
			final float rating = (touchedCoordinate * MAX_RATING) /viewWidth;
			setRating((int)Math.ceil(rating));
		}
		return true;
	}

}
