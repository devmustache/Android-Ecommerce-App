package com.devmoustache.mtecommerce.repos

import com.devmoustache.mtecommerce.model.Product
import retrofit2.http.GET

interface EcommerceApi {

    @GET("Android-Ecommerce-App/docs/allproducts.json")
    suspend fun fetchAllProducts(): List<Product>
}
