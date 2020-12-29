package com.example.mytestprojectforandroidlistadapter

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ItemClass::class], version = 1)
abstract class ItemClassDatabase:RoomDatabase() {
    abstract fun itemDao(): ItemClassDao
}