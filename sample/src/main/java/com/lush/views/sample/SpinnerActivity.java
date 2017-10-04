package com.lush.views.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.lush.view.spinner.IntegerSpinner;
import com.lush.view.spinner.LanguageSpinner;
import com.lush.view.spinner.StringSpinner;

import java.util.ArrayList;

/**
 * Sample of the spinners available
 *
 * @author Jamie Cruwys
 */
public class SpinnerActivity extends AppCompatActivity
{
	private IntegerSpinner integerSpinner;
	private LanguageSpinner languageSpinner;
	private StringSpinner stringSpinner;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spinners);

		integerSpinner = findViewById(R.id.integer);
		languageSpinner = findViewById(R.id.language);
		stringSpinner = findViewById(R.id.string);

		setupSpinners();
	}

	private void setupSpinners()
	{
		setupIntegerSpinner();
		setupLanguageSpinner();
		setupStringSpinner();
	}

	private void setupIntegerSpinner()
	{
		if (integerSpinner == null)
		{
			return;
		}

		integerSpinner.setZeroText("MM");
		integerSpinner.setRange(0, 12);
		integerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
			{
				Toast.makeText(SpinnerActivity.this, "Selected " + integerSpinner.getSelected(), Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> adapterView)
			{

			}
		});
	}

	private void setupLanguageSpinner()
	{
		if (languageSpinner == null)
		{
			return;
		}

		// TODO: Setup language spinner
	}

	private void setupStringSpinner()
	{
		if (stringSpinner == null)
		{
			return;
		}

		ArrayList<String> strings = new ArrayList<>();
		strings.add("Bath Bomb");
		strings.add("Bubble Bar");
		strings.add("Shampoo");
		strings.add("Conditioner");
		strings.add("Face Mask");
		stringSpinner.setItems(strings);
		stringSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
			{
				Toast.makeText(SpinnerActivity.this, "Selected " + stringSpinner.getSelected(), Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> adapterView)
			{

			}
		});
	}
}