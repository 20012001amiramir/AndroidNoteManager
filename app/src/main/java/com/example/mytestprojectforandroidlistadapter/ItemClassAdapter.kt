package com.example.mytestprojectforandroidlistadapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item_layout.view.*


class ItemClassAdapter(_context: Context, _itemList: List<ItemClass>) : BaseAdapter() {
    var itemList : List<ItemClass> = _itemList
    var context: Context? = null
    init{
        this.context = _context
    }
    override fun getCount(): Int {
        return itemList.size
    }

    override fun getItem(position: Int): Any {
        return itemList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val item = this.itemList[position]
        val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = inflator.inflate(R.layout.item_layout, null)
        itemView.textTitle.text = item._title
        itemView.textDescription.text = item._description

        return itemView
    }

}