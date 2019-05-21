package com.example.acesstest.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.acesstest.R
import com.example.acesstest.main.ViewDelegate
import kotlinx.android.synthetic.main.item_layout.view.*

class ItemRecyclerViewAdapter(private val viewDelegate: ViewDelegate) :
        RecyclerView.Adapter<ItemRecyclerViewAdapter.ItemHolder>() {

    private val dataList: MutableList<ItemModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ItemHolder = ItemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
    )

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(dataList[position])
    }

    fun switchDataList(newDataList: List<ItemModel>) {
        dataList.clear()
        dataList.addAll(newDataList)
        notifyDataSetChanged()
    }

    inner class ItemHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(model: ItemModel) {
            view.itemTitle.text = model.title

            view.setOnClickListener {
                model.action.onItemClick(
                        delegate = viewDelegate,
                        item = model
                )
            }
        }
    }
}