package com.bogsnebes.fishermansguide

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(listItems: ArrayList<ListItems>, context: Context) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    val listItemsR = listItems
    val contextR = context

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNameList = view.findViewById<TextView>(R.id.tvNameList)
        val tvDescList = view.findViewById<TextView>(R.id.tvDescrList)
        val tvImageList = view.findViewById<ImageView>(R.id.im)

        fun bind(listItems: ListItems, context: Context) {
            tvNameList.text = listItems.textName
            tvDescList.text = listItems.textDesc
            tvImageList.setImageResource(listItems.im)
            itemView.setOnClickListener {
                Toast.makeText(context, "${tvNameList.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = listItemsR.get(position)
        holder.bind(listItem, contextR)
    }

    override fun getItemCount(): Int {
        return listItemsR.size
    }
}