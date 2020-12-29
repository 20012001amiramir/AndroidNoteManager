package com.example.mytestprojectforandroidlistadapter

import android.content.ClipData
import androidx.room.*


@Dao
interface ItemClassDao {
    @Query("SELECT * FROM ItemClass")
    fun getAllItems(): List<ItemClass>

    @Insert
    fun insert(vararg item: ItemClass)

    @Delete
    fun delete(item: ItemClass)

    @Query("DELETE FROM ItemClass")
    fun deleteAll()
}
