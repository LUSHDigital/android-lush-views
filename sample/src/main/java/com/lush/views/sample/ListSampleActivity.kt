package com.lush.views.sample

import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lush.lib.adapter.BaseSelectableListAdapter
import com.lush.lib.listener.OnListItemClickListener
import com.lush.view.holder.BaseSelectableViewHolder
import com.lush.view.holder.BaseViewHolder
import com.lush.views.sample.base.BaseSampleActivity
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.item_person.view.*

class ListSampleActivity: BaseSampleActivity(), OnListItemClickListener<Person>
{
	lateinit var adapter: PersonAdapter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_list)

		val items = arrayListOf(
				Person("Agent", "Smith"),
				Person("James", "Bond"),
				Person("Darth", "Vader"),
				Person("Mary", "Poppins"),
				Person("John", "McClane"),
				Person("Ace", "Ventura"),
				Person("Jack", "Sparrow"),
				Person("Frodo", "Baggins"),
				Person("Rocky", "Balboa"),
				Person("Forrest", "Gump"),
				Person("Indiana", "Jones")
		)

		adapter = PersonAdapter(items, this)
		list.adapter = adapter
		list.layoutManager = LinearLayoutManager(this)
	}

	override fun onItemClick(item: Person, view: View)
	{
		if (adapter.getSelected().contains(item))
		{
			adapter.removeSelected(item)
		}
		else
		{
			adapter.addSelected(item)
		}
	}
}

class PersonAdapter(items: ArrayList<Person> = arrayListOf(), listener: OnListItemClickListener<Person>? = null): BaseSelectableListAdapter<Person>(items, listener)
{
	override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<Person>
	{
		val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_person, parent, false)
		return PersonViewHolder(view)
	}
}

class PersonViewHolder(view: View): BaseSelectableViewHolder<Person>(view)
{
	override fun bind(model: Person)
	{
		itemView.person_name.text = "${model.name} ${model.surname}"
	}

	override fun setSelected(selected: Boolean)
	{
		val backgroundColor = if (selected) Color.BLACK else Color.WHITE
		val textColor = if (selected) Color.WHITE else Color.BLACK
		itemView.setBackgroundColor(backgroundColor)
		itemView.person_name.setTextColor(textColor)
	}
}

data class Person(val name: String, val surname: String)