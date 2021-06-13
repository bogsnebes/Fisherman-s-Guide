package com.bogsnebes.fishermansguide

import android.content.res.TypedArray
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(R.layout.activity_main),
    NavigationView.OnNavigationItemSelectedListener {
    private lateinit var navigationView: NavigationView
    private lateinit var mainList: RecyclerView
    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigationView = findViewById(R.id.navigation_menu)
        navigationView.setNavigationItemSelectedListener(this)

        mainList = findViewById(R.id.mainList)

        val list = ArrayList<ItemList>()
        list.addAll(
            fillArrays(
                resources.getStringArray(R.array.fish),
                resources.getStringArray(R.array.fish_description),
                getImageId(R.array.fish_image)
            )
        )

        mainList.hasFixedSize()
        mainList.layoutManager = LinearLayoutManager(this)
        myAdapter = MyAdapter(list, this)
        mainList.adapter = myAdapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.fish -> {
                myAdapter.updateAdapter(
                    fillArrays(
                        resources.getStringArray(R.array.fish),
                        resources.getStringArray(R.array.fish_description),
                        getImageId(R.array.fish_image)
                    )
                )
            }
            R.id.bait -> {
                myAdapter.updateAdapter(
                    fillArrays(
                        resources.getStringArray(R.array.bait),
                        resources.getStringArray(R.array.bait_description),
                        getImageId(R.array.bait_image)
                    )
                )
            }
            R.id.history -> Toast.makeText(this, "Test #3", Toast.LENGTH_SHORT).show()
            R.id.tackle -> Toast.makeText(this, "Test #4", Toast.LENGTH_SHORT).show()
        }

        return true
    }

    fun fillArrays(
        titleArray: Array<String>,
        contentArray: Array<String>,
        imageArray: IntArray
    ): ArrayList<ItemList> {
        val listItemArray = ArrayList<ItemList>()
        for (i in titleArray.indices) {
            val itemList = ItemList(imageArray[i], titleArray[i], contentArray[i])
            listItemArray.add(itemList)
        }
        return listItemArray
    }

    fun getImageId(imageArrayId: Int): IntArray {
        val tArray: TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for (i in ids.indices) {
            ids[i] = tArray.getResourceId(i, 0)
        }
        tArray.recycle()
        return ids
    }
}
