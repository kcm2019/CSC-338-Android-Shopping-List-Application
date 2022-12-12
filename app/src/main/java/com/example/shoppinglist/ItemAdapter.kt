package com.example.shoppinglist

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class ItemAdapter(
    private val items: MutableList<Item>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item,
                parent,
                false
            )
        )
    }

    fun addItem(item: Item) {
        items.add(item)
        notifyItemInserted(items.size - 1)
    }

    fun deleteItems() {
        items.removeAll { item ->
            item.isChecked
        }

        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items[position]
        holder.itemView.apply {
            tvTitle.text = currentItem.title
            cbDelete.isChecked = currentItem.isChecked
            cbDelete.setOnCheckedChangeListener { _, isChecked ->
                currentItem.isChecked = !currentItem.isChecked
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}