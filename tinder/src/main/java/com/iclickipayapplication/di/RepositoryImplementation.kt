package com.iclickipayapplication.di

import com.iclickipay.data.model.tinder.ProductsModelItemModel
import com.iclickipay.data.remote.tinder.ProductAPIInterface
import com.iclickipay.data.repository.tinder.Repository
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(
    val apiHero: ProductAPIInterface
): Repository {
    override suspend fun getDetails(): List<ProductsModelItemModel> {
        return apiHero.getDetails()
    }
}