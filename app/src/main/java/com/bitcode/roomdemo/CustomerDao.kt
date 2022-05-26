package com.bitcode.roomdemo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CustomerDao {

    @Query("select * from customers")
    fun getAllCustomers() : List<Customer>

    @Insert
    fun addCustomer(customer: Customer)
}