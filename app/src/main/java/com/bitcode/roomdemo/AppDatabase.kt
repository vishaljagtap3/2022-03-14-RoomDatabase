package com.bitcode.roomdemo

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Product::class, Customer::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getProductDao() : ProductDao
    abstract fun getCustomerDao() : CustomerDao
}