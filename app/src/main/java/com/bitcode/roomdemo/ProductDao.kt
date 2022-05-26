package com.bitcode.roomdemo

import androidx.room.*

@Dao
interface ProductDao {

    @Query("select * from products")
    fun getAllProducts() : List<Product>

    @Insert
    fun addProduct(product: Product)

    @Delete
    fun deleteProduct(product: Product)

    @Update
    fun updateProduct(product: Product)
}