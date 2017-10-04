package com.lush.views.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SampleActivity extends AppCompatActivity
{
	private Button spinnersButton;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample);

		spinnersButton = findViewById(R.id.button_spinners);

		setupButtons();
	}

	private void setupButtons()
	{
		setupSpinnersButton();
	}

	private void setupSpinnersButton()
	{
		if (spinnersButton == null)
		{
			return;
		}

		spinnersButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Intent intent = new Intent(SampleActivity.this, SpinnerActivity.class);
				startActivity(intent);
			}
		});
	}
}