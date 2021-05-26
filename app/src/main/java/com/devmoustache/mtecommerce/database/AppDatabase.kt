package com.devmoustache.mtecommerce.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devmoustache.mtecommerce.model.Cart


@Database(entities = [ProductFromDatabase::class, Cart::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun cartDao(): CartDao
}
