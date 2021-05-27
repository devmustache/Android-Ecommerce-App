package com.devmoustache.mtecommerce.repos

import com.devmoustache.mtecommerce.model.Product
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL

class ProductsRepository {

    private fun retrofit(): EcommerceApi {
        return Retrofit.Builder()
            .baseUrl("https://devmustache.github.io/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(EcommerceApi::class.java)
    }

    suspend fun fetchAllProductsRetrofit(): List<Product> {
        return retrofit().fetchAllProducts()
    }

    fun getAllProducts(): Single<List<Product>> {
        return Single.create<List<Product>> {
            it.onSuccess(fetchProducts())
        }
    }

    suspend fun searchForProducts(term: String): List<Product> {
        return fetchAllProductsRetrofit().filter { it.title.contains(term, true) }
    }

    fun getProductByName(name: String): Single<Product> {
        return Single.create<Product> {
            val product = fetchProducts().first { it.title == name }
            it.onSuccess(product)
        }
    }

    fun fetchProducts(): List<Product> {
        val json =
            URL("https://devmustache.github.io/Android-Ecommerce-App/docs/produtos.json").readText()
        return Gson().fromJson(json, Array<Product>::class.java).toList()
    }
}
