package com.example.mytestprojectforandroidlistadapter

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.room.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


open class MainActivity : AppCompatActivity() {
    var adapter: ItemClassAdapter? = null
    lateinit var db: ItemClassDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch {
            db = Room.databaseBuilder(
                applicationContext,
                ItemClassDatabase::class.java,
                "database_item"
            ).build()
            db.itemDao().deleteAll()
        }
        plus.setOnClickListener {
            val dialog = NoteClass()
            dialog.show(supportFragmentManager, "customDialog")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.navbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId){
        R.id.action_delete -> {
            GlobalScope.launch {
                db.itemDao().deleteAll()
                adapter = ItemClassAdapter(applicationContext, db.itemDao().getAllItems())
            }
            Grid.adapter = adapter

            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    fun AddNote(title: String, description: String){
        GlobalScope.launch {
            db.itemDao().insert(ItemClass(title, description))
            adapter = ItemClassAdapter(applicationContext, db.itemDao().getAllItems())
        }
        Grid.adapter = adapter

    }

}
