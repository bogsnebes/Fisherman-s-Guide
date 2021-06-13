package com.bogsnebes.fishermansguide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(R.layout.activity_main),
    NavigationView.OnNavigationItemSelectedListener {
    private lateinit var navigationView: NavigationView
    private lateinit var rcView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigationView = findViewById(R.id.navigation_menu)
        navigationView.setNavigationItemSelectedListener(this)

        rcView = findViewById(R.id.rcView)

        val list = ArrayList<ListItems>()
        list.add(ListItems(R.drawable.shuca, "Бог", "Это Бог"))
        list.add(ListItems(R.drawable.anonymos, "Anonimus", "Это Анонимус"))
        list.add(ListItems(R.drawable.monke, "Обезьянка", "Это monke"))
        list.add(ListItems(R.drawable.morgenshtern, "Morgenshtern", "Это morgen в Армии"))

        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        rcView.adapter = MyAdapter(list, this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.fish -> Toast.makeText(this, "Test #1", Toast.LENGTH_SHORT).show()
            R.id.bait -> Toast.makeText(this, "Test #2", Toast.LENGTH_SHORT).show()
            R.id.history -> Toast.makeText(this, "Test #3", Toast.LENGTH_SHORT).show()
            R.id.tackle -> Toast.makeText(this, "Test #4", Toast.LENGTH_SHORT).show()
        }

        return true
    }
}
