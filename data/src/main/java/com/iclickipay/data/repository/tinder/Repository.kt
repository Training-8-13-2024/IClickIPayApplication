package com.iclickipay.data.repository.tinder

import com.iclickipay.data.model.tinder.ProductsModelItemModel

interface Repository {
    suspend fun getDetails(): List<ProductsModelItemModel>
}