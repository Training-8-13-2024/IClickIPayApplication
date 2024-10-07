package com.iclickipay.data.remote.tinder

import com.iclickipay.data.model.tinder.ProductsModelItemModel
import retrofit2.http.GET

interface ProductAPIInterface {
    @GET(ProductAPIDetails.END_POINTS)
    suspend fun getDetails(): List<ProductsModelItemModel>
}