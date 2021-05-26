package com.devmoustache.mtecommerce.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.devmoustache.mtecommerce.model.Cart

@Dao
interface CartDao {

    @Query("SELECT * FROM Cart")
    fun getAll(): List<Cart>

    @Insert
    fun insertAll(vararg item: Cart)
}
