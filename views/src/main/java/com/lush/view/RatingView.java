package com.lush.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
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
	protected static final  int MAX_RATING = 5;
	private Drawable fullStarDrawable, emptyStarDrawable;

	public RatingView(Context context)
	{
		super(context);
		initViewGroup(context, null);
		updateStars();
	}

	public RatingView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		initViewGroup(context, attrs);
		updateStars();
	}

	public RatingView(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
		initViewGroup(context, attrs);
		updateStars();
	}

	/**
	 * Setup the ViewGroup to get the desired effect for showing ratings
	 */
	private void initViewGroup(Context context, AttributeSet attrs)
	{
		setOrientation(HORIZONTAL);
		if(attrs != null)
		{
			TypedArray a = context.getTheme().obtainStyledAttributes(
					attrs,
					R.styleable.RatingView,
					0, 0);

			try
			{
				fullStarDrawable = a.getDrawable(R.styleable.RatingView_fullStarDrawable);
				emptyStarDrawable = a.getDrawable(R.styleable.RatingView_emptyStarDrawable);
			}
			finally
			{
				a.recycle();
			}
		}

		if(emptyStarDrawable == null || fullStarDrawable ==null)
		{
			fullStarDrawable = getResources().getDrawable(R.drawable.ic_star_full);
			emptyStarDrawable = getResources().getDrawable(R.drawable.ic_star_empty);
		}
	}

	public void setRating(int rating)
	{
		if (rating > MAX_RATING)
		{
			// Cap the maximum
			rating = MAX_RATING;
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
			img.setImageDrawable(fullStarDrawable);
			addView(img);
		}

		int remaining = MAX_RATING - rating;

		for (int i = 0; i < remaining; i++)
		{
			ImageView img = new ImageView(getContext());
			img.setImageDrawable(emptyStarDrawable);
			addView(img);
		}
	}
}
