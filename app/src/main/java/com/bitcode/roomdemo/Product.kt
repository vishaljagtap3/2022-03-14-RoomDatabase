package com.bitcode.roomdemo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

//@Entity(tableName = "products", primaryKeys = ["id", "title"])
@Entity(tableName = "products", indices = [Index(value = ["price"])])
data class Product(
    @PrimaryKey @ColumnInfo(name = "_id") val id : Int,
    @ColumnInfo(name = "title") val title : String,
    val price : Int
)
