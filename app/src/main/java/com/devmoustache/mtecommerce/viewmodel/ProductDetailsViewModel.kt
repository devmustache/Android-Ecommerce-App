package com.devmoustache.mtecommerce.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devmoustache.mtecommerce.model.Product
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class ProductDetailsViewModel : ViewModel() {

    val productDetails = MutableLiveData<Product>()

    fun fetchProductDetails(productTitle: String) {
        viewModelScope.launch(Dispatchers .Default) {
            val json =
                URL("produtos.json").readText()
            val list = Gson().fromJson(json, Array<Product>::class.java).toList()
            val product = list.first { it.title == productTitle }

            productDetails.postValue(product)
        }
    }
}
