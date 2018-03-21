package com.lush.views.sample;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lush.lib.listener.OnListItemClickListener;
import com.lush.views.sample.base.BaseSampleActivity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class JavaListSampleActivity extends BaseSampleActivity implements OnListItemClickListener<Person>
{
	private PersonAdapter adapter = null;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);

		ArrayList<Person> people = new ArrayList<>();
		people.add(null);
		people.add(new Person("Agent", "Smith"));
		people.add(null);
		people.add(new Person("James", "Bond"));
		people.add(null);
		people.add(new Person("Darth", "Vader"));
		people.add(null);
		people.add(new Person("Mary", "Poppins"));
		people.add(null);
		people.add(new Person("John", "McClane"));

		RecyclerView list = findViewById(R.id.list);
		adapter = new PersonAdapter(people, this);
		list.setAdapter(adapter);
		list.setLayoutManager(new LinearLayoutManager(this));
	}

	@Override
	public void onItemClick(Person item, @NotNull View view)
	{
		if (adapter.getSelected().contains(item))
		{
			adapter.removeSelected(item);
		}
		else
		{
			adapter.addSelected(item);
		}
	}
}