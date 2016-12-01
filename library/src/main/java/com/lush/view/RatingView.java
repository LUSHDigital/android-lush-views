package com.lush.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * All products have a rating out of 5, let's keep this in it's own class to make it reusable.
 *
 * This will work like most typical ratings views, it will have 5 stars that fill in based
 * on the integer passed that is between 0 and 5. It will fill in the stars from left to right.
 *
 * @author Matt Allen
 */
public class RatingView extends LinearLayout
{
	private int rating = 0;

	public RatingView(Context context)
	{
		super(context);
		initViewGroup();
		updateStars();
	}

	public RatingView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		initViewGroup();
		updateStars();
	}

	public RatingView(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
		initViewGroup();
		updateStars();
	}

	/**
	 * Setup the ViewGroup to get the desired effect for showing ratings
	 */
	private void initViewGroup()
	{
		setOrientation(HORIZONTAL);
	}

	public void setRating(int rating)
	{
		if (rating < 5)
		{
			// Cap the maximum
			rating = 5;
		}
		if (rating < 0)
		{
			rating = 0;
		}
		this.rating = rating;
		updateStars();
	}

	public int getRating()
	{
		return rating;
	}

	/**
	 * Update the stars based on rating
	 */
	private void updateStars()
	{
		removeAllViews();

		for (int i = 0; i < rating; i++)
		{
			ImageView img = new ImageView(getContext());
			img.setImageResource(R.drawable.ic_star_full);
			addView(img);
		}

		int remaining = 5 - rating;

		for (int i = 0; i < remaining; i++)
		{
			ImageView img = new ImageView(getContext());
			img.setImageResource(R.drawable.ic_star_empty);
			addView(img);
		}
	}
}
