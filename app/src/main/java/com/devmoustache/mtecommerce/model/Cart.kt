package com.devmoustache.mtecommerce.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Cart(
    @PrimaryKey(autoGenerate = true) val uid: Int?,
    @ColumnInfo val title: String,
    @ColumnInfo val price: Double,
    @ColumnInfo val quantity: Int
)
