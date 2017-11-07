package com.lush.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Calendar;

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
	private static final String KEY_EDIT_TEXT_TEXT = "KEY_EDIT_TEXT_TEXT";

	private TextView titleView;
	private TextView errorView;
	private EditText editText;
	private ImageView errorImageView;

	private float height;
	private String hint;
	private String title;
	private int inputType;
	private boolean copyPasteEnabled;

	private boolean isErrorVisible;
	private boolean isManualTextChange;
	private TextWatcher textWatcher;

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
				copyPasteEnabled = a.getBoolean(R.styleable.LushEditText_copyPasteEnabled, true);
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
		errorView = lushEditTextLayout.findViewById(R.id.lush_edit_text_error);
		titleView = lushEditTextLayout.findViewById(R.id.lush_edit_text_title);
		editText = lushEditTextLayout.findViewById(R.id.lush_edit_text);
		errorImageView = lushEditTextLayout.findViewById(R.id.red_exclamation);
		addView(lushEditTextLayout);
	}

	private void formatViews(Context context)
	{
		RelativeLayout.LayoutParams exclamationLayoutParams = (RelativeLayout.LayoutParams) errorImageView.getLayoutParams();
		exclamationLayoutParams.height = (int) height;
		exclamationLayoutParams.width = (int) height;
		errorImageView.setLayoutParams(exclamationLayoutParams);
		editText.setId(Calendar.getInstance().get(Calendar.MILLISECOND));
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
		errorImageView.setVisibility(isErrorVisible ? VISIBLE : GONE);
		setCopyPasteEnabled(copyPasteEnabled);
	}

	public void setCopyPasteEnabled(final boolean enabled)
	{
		EditText editText = getEditText();

		if (editText != null && !enabled)
		{
			editText.setLongClickable(false);
			editText.setCustomSelectionActionModeCallback(new ActionMode.Callback()
			{
				@Override
				public boolean onCreateActionMode(ActionMode mode, Menu menu)
				{
					return false;
				}

				@Override
				public boolean onPrepareActionMode(ActionMode mode, Menu menu)
				{
					return false;
				}

				@Override
				public boolean onActionItemClicked(ActionMode mode, MenuItem item)
				{
					return false;
				}

				@Override
				public void onDestroyActionMode(ActionMode mode)
				{

				}
			});
		}
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after)
	{
		if (textWatcher != null)
		{
			textWatcher.beforeTextChanged(s, start, count, after);
		}
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count)
	{
		if (isManualTextChange && isErrorVisible)
		{
			isErrorVisible = false;
			errorView.setVisibility(GONE);
			errorImageView.setVisibility(GONE);
		}
		isManualTextChange = true;
		if (textWatcher != null)
		{
			textWatcher.onTextChanged(s, start, before, count);
		}
	}

	@Override
	public void afterTextChanged(Editable s)
	{
		if (textWatcher != null)
		{
			textWatcher.afterTextChanged(s);
		}
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
		errorImageView.setVisibility(isErrorVisible ? VISIBLE : GONE);

	}

	/**
	 * Sets the title.
	 *
	 * @param title the title.
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
	 * @param value the value.
	 */
	public void setText(CharSequence value)
	{
		editText.setText(value);
	}

	/**
	 * Enables or disables the EditText.
	 *
	 * @param value set true for enabled.
	 */
	public void setEditTextEnabled(boolean value)
	{
		editText.setEnabled(value);
	}

	/**
	 * Gets hint of the EditText.
	 *
	 * @return the hint
	 */
	@NonNull public String getHint()
	{
		if (editText.getHint() == null)
		{
			editText.setHint("");
		}

		return editText.getHint().toString();
	}

	/**
	 * Sets hint of the EditText.
	 *
	 * @param hint the hint.
	 */
	public void setHint(@Nullable String hint)
	{
		if (hint == null)
		{
			hint = "";
		}

		editText.setHint(hint);
		this.hint = hint;
	}

	@Override
	public Parcelable onSaveInstanceState()
	{
		Bundle bundle = new Bundle();
		bundle.putParcelable("superState", super.onSaveInstanceState());
		bundle.putBoolean(KEY_ERROR_VISIBLE, isErrorVisible);
		bundle.putString(KEY_ERROR_TEXT, errorView.getText().toString());
		bundle.putString(KEY_EDIT_TEXT_TEXT, editText.getText().toString());
		return bundle;
	}

	@Override
	public void onRestoreInstanceState(Parcelable state)
	{
		if (state instanceof Bundle)
		{
			Bundle bundle = (Bundle) state;
			isManualTextChange = false; // Setting this false when the change is not user induced.
			editText.setText(bundle.getString(KEY_EDIT_TEXT_TEXT));
			isErrorVisible = bundle.getBoolean(KEY_ERROR_VISIBLE);
			state = bundle.getParcelable("superState");
			errorView.setText(bundle.getString(KEY_ERROR_TEXT));
			errorView.setVisibility(isErrorVisible ? VISIBLE : GONE);
			errorImageView.setVisibility(isErrorVisible ? VISIBLE : GONE);
		}
		super.onRestoreInstanceState(state);
	}

	/**
	 * Sets text watcher
	 *
	 * @param textWatcher the text watcher
	 */
	public void setTextWatcher(TextWatcher textWatcher)
	{
		this.textWatcher = textWatcher;
	}

	/**
	 * Gets the title view.
	 *
	 * @return the title view
	 */
	public TextView getTitleView()
	{
		return titleView;
	}

	/**
	 * Gets the error view.
	 *
	 * @return the error view
	 */
	public TextView getErrorView()
	{
		return errorView;
	}

	/**
	 * Gets the EditText view.
	 *
	 * @return the EditText view
	 */
	public EditText getEditText()
	{
		return editText;
	}

	/**
	 * Gets the error image view.
	 *
	 * @return the error image view
	 */
	public ImageView getErrorImageView()
	{
		return errorImageView;
	}
}
