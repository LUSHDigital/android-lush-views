package com.lush.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Custom edit text class with title and error view. Custom attributes include:
 * <p>
 * <ul>
 * <li>editTextHeight</li>
 * <li>editTextHint</li>
 * <li>title</li>
 * <li>inputType</li>
 * </ul>
 * </p>
 *
 * @author Gokhan
 */
public class LushEditText extends LinearLayout implements TextWatcher
{
	private static final float DEFAULT_HEIGHT_DP = 45;
	private static final String KEY_ERROR_VISIBLE = "KEY_ERROR_VISIBLE";
	private static final String KEY_ERROR_TEXT = "KEY_ERROR_TEXT";

	private TextView titleView;
	private TextView errorView;
	private EditText editText;
	private ImageView redExclamationImage;

	private float height;
	private String hint;
	private String title;
	private int inputType;

	private boolean isErrorVisible;
	private boolean isManualTextChange;

	public LushEditText(Context context)
	{
		super(context);
		initEditText(context, null);
	}

	public LushEditText(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		initEditText(context, attrs);
	}

	public LushEditText(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
		initEditText(context, attrs);
	}

	private void initEditText(Context context, AttributeSet attrs)
	{
		populateCustomAttributes(context, attrs);
		populateViews(context);
		formatViews(context);
	}

	private void populateCustomAttributes(Context context, AttributeSet attrs)
	{
		if (attrs != null)
		{
			TypedArray a = context.getTheme().obtainStyledAttributes(
					attrs,
					R.styleable.LushEditText,
					0, 0);

			try
			{
				height = a.getDimension(R.styleable.LushEditText_editTextHeight, DEFAULT_HEIGHT_DP * Resources.getSystem().getDisplayMetrics().density);
				hint = a.getString(R.styleable.LushEditText_editTextHint);
				title = a.getString(R.styleable.LushEditText_title);
				inputType = a.getInt(R.styleable.LushEditText_android_inputType, InputType.TYPE_CLASS_TEXT);

			}
			finally
			{
				a.recycle();
			}
		}
	}

	private void populateViews(Context context)
	{
		LinearLayout lushEditTextLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.view_lush_edit_text, this, false);
		errorView = (TextView) lushEditTextLayout.findViewById(R.id.lush_edit_text_error);
		titleView = (TextView) lushEditTextLayout.findViewById(R.id.lush_edit_text_title);
		editText = (EditText) lushEditTextLayout.findViewById(R.id.lush_edit_text);
		redExclamationImage = (ImageView) lushEditTextLayout.findViewById(R.id.red_exclamation);
		addView(lushEditTextLayout);
	}

	private void formatViews(Context context)
	{
		RelativeLayout.LayoutParams exclamationLayoutParams = (RelativeLayout.LayoutParams) redExclamationImage.getLayoutParams();
		exclamationLayoutParams.height = (int) height;
		exclamationLayoutParams.width = (int) height;
		redExclamationImage.setLayoutParams(exclamationLayoutParams);
		editText.addTextChangedListener(this);
		editText.setHint(hint);
		isManualTextChange = false; // setInputType triggers automated text change
		editText.setInputType(inputType);
		editText.setTextAppearance(context, R.style.Text_Black_HelveticaRoman);
		RelativeLayout.LayoutParams editTextLayoutParams = (RelativeLayout.LayoutParams) editText.getLayoutParams();
		editTextLayoutParams.height = (int) height;
		editText.setLayoutParams(editTextLayoutParams);
		setTitle(title);
		errorView.setVisibility(isErrorVisible ? VISIBLE : GONE);
		redExclamationImage.setVisibility(isErrorVisible ? VISIBLE : GONE);
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after)
	{
		// Not used
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count)
	{
		if (isManualTextChange && isErrorVisible)
		{
			isErrorVisible = false;
			errorView.setVisibility(GONE);
			redExclamationImage.setVisibility(GONE);
		}
		isManualTextChange = true;
	}

	@Override
	public void afterTextChanged(Editable s)
	{
		// Not used
	}

	/**
	 * Sets the error message.
	 *
	 * @param error the error message.
	 */
	public void setError(CharSequence error)
	{
		isErrorVisible = !TextUtils.isEmpty(error);
		errorView.setVisibility(isErrorVisible ? VISIBLE : GONE);
		errorView.setText(error);
		redExclamationImage.setVisibility(isErrorVisible ? VISIBLE : GONE);

	}

	/**
	 * Sets the title.
	 *
	 * @param title the title
	 */
	public void setTitle(CharSequence title)
	{
		titleView.setText(title);
		titleView.setVisibility(TextUtils.isEmpty(title) ? GONE : VISIBLE);
	}

	/**
	 * Gets the EditText content.
	 *
	 * @return the EditText content.
	 */
	public Editable getText()
	{
		return editText.getText();
	}

	/**
	 * Sets the EditText content.
	 *
	 * @param value the value
	 */
	public void setText(CharSequence value)
	{
		editText.setText(value);
	}

	@Override
	public Parcelable onSaveInstanceState()
	{
		Bundle bundle = new Bundle();
		bundle.putParcelable("superState", super.onSaveInstanceState());
		bundle.putBoolean(KEY_ERROR_VISIBLE, isErrorVisible);
		bundle.putString(KEY_ERROR_TEXT, errorView.getText().toString());
		return bundle;
	}

	@Override
	public void onRestoreInstanceState(Parcelable state)
	{
		if (state instanceof Bundle)
		{
			Bundle bundle = (Bundle) state;
			isErrorVisible = bundle.getBoolean(KEY_ERROR_VISIBLE);
			state = bundle.getParcelable("superState");
			isManualTextChange = false;
			errorView.setText(bundle.getString(KEY_ERROR_TEXT));
			errorView.setVisibility(isErrorVisible ? VISIBLE : GONE);
			redExclamationImage.setVisibility(isErrorVisible ? VISIBLE : GONE);
		}
		super.onRestoreInstanceState(state);
	}
}
