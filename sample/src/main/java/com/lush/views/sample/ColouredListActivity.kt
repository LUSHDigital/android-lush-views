package com.lush.views.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.TextView
import com.lush.lib.adapter.BaseListAdapter
import com.lush.view.holder.BaseViewHolder
import kotlinx.android.synthetic.main.activity_list.*

/**
 * @author Matt Allen
 */
class ColouredListActivity: AppCompatActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_list)
		list?.layoutManager = LinearLayoutManager(this)
		list?.adapter = ListAdapter(getProductsList())
	}

	private fun getProductsList(): List<Product> = listOf(
			Product("Big Blue", "Blue"),
			Product("Avobath", "Avocado"),
			Product("Butterball", "Probably butter"),
			Product("Comforter Shower Cream", "Please come back"),
			Product("Sleepy", "How many more could we sell?"),
			Product("Charity Pot", "You gotta pay the VAT, love")
	)

	private class ListAdapter(products: List<Product>): BaseListAdapter<Product>(products, null, true)
	{
		override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Product>
		{
			val inflator = LayoutInflater.from(parent.context)
			val view = inflator.inflate(R.layout.item_product, parent, false)
			return ViewHolder(view)
		}
	}

	private class ViewHolder(view: View?): BaseViewHolder<Product>(view)
	{
		override fun bind(model: Product)
		{
			itemView?.findViewById<TextView>(R.id.name)?.text = model.name
			itemView?.findViewById<TextView>(R.id.description)?.text = model.description
		}
	}

	private data class Product(val name: String, val description: String)
}
