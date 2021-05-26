package com.devmoustache.mtecommerce.repos

import com.devmoustache.mtecommerce.model.Product
import retrofit2.http.GET

interface EcommerceApi {

    @GET("api/ecommerce/v1/allProducts")
    suspend fun fetchAllProducts(): List<Product>
}
