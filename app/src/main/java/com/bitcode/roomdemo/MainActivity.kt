package com.bitcode.roomdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var db : AppDatabase
    lateinit var productDao: ProductDao
    lateinit var customerDao: CustomerDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "bitcode_db"
        ).build()

        CoroutineScope(Dispatchers.IO).launch {

            productDao = db.getProductDao()
            customerDao = db.getCustomerDao()

            /*productDao.addProduct(Product(101, "Product 101", 1001))
            productDao.addProduct(Product(102, "Product 102", 1002))
            productDao.addProduct(Product(103, "Product 103", 1003))
            productDao.addProduct(Product(104, "Product 104", 1004))*/

            var products = productDao.getAllProducts()
            for(product in products) {
                mt(product.toString())
            }

            mt("------------------------------")

            //productDao.deleteProduct(Product(104, "Product 104", 1004))
            productDao.updateProduct(Product(103, "Laptop", 2222))

            products = productDao.getAllProducts()

            for(product in products) {
                mt(product.toString())
            }

            db.close()
        }


    }

    private fun mt(text : String) {
        Log.e("tag", text)
    }

}