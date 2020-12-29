package com.example.mytestprojectforandroidlistadapter

import androidx.room.*

@Entity
data class ItemClass(
    var _title: String,
    var _description: String,

){

    @PrimaryKey(autoGenerate = true) var _id: Int? = null
}
