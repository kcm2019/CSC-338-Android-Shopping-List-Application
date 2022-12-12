package com.example.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var  itemAdapter : ItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        itemAdapter = ItemAdapter(mutableListOf())

        rvShoppingItems.adapter = itemAdapter
        rvShoppingItems.layoutManager = LinearLayoutManager(this)

        btnAddItem.setOnClickListener {
            val title = etItemTitle.text.toString()
            if(title.isNotEmpty()){
                val item = Item(title)
                itemAdapter.addItem(item)
                etItemTitle.text.clear()
            }
        }

        btnRemove.setOnClickListener {
            itemAdapter.deleteItems()
        }
    }
}