package com.example.googlebooks

import android.content.Context
import android.widget.BaseAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class CustomAdapter(context: Context,booksList:ArrayList<Model>):BaseAdapter() {
    private val layoutInflater: LayoutInflater
    private val booksList:ArrayList<Model>
    init {
        this.layoutInflater = LayoutInflater.from(context)
        this.booksList=booksList
    }

    override fun getCount(): Int {
        return booksList.size
    }

    override fun getItem(position: Int): Any {
        return booksList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val view: View?
        val listRowHolder: ListRowHolder
        if (convertView == null) {
            view = this.layoutInflater.inflate(R.layout.adapter_layout, parent, false)
            listRowHolder = ListRowHolder(view)
            view.tag = listRowHolder
        } else {
            view = convertView
            listRowHolder = view.tag as ListRowHolder
        }

        listRowHolder.titleId.text = booksList.get(position).title
        listRowHolder.subtitleId.text = booksList.get(position).subtitle ?: ""
        listRowHolder.authorsId.text = booksList.get(position).authors?.get(0) ?: ""
        return view
    }
}

private class ListRowHolder(row: View?) {
    public val imageId: ImageView
    public val titleId: TextView
    public val subtitleId: TextView
    public val authorsId: TextView
    public val listItem: LinearLayout

    init {
        this.imageId = row?.findViewById<ImageView>(R.id.thumbnail) as ImageView
        this.titleId = row?.findViewById<TextView>(R.id.title) as TextView
        this.subtitleId = row?.findViewById<TextView>(R.id.subtitle) as TextView
        this.authorsId = row?.findViewById<TextView>(R.id.authors) as TextView
        this.listItem = row?.findViewById<LinearLayout>(R.id.listItem) as LinearLayout
    }
}
