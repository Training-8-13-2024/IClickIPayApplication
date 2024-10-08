package com.iclickipayapplication.common.di

import com.iclickipay.data.model.learn.TeacherDataItemItemModel
import com.iclickipay.data.model.tinder.ProductsModelItemModel
import com.iclickipay.data.remote.learn.TeacherApiInterface
import com.iclickipay.data.remote.tinder.ProductAPIInterface
import com.iclickipay.data.repository.learn.Repository
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(
    val apiHero: ProductAPIInterface,
    val apiTeacher: TeacherApiInterface
): Repository {
    override suspend fun getDetails(): List<ProductsModelItemModel> {
        return apiHero.getDetails()
    }

    override suspend fun getDetailsTeacher(): List<TeacherDataItemItemModel> {
        return apiTeacher.getDetails()
    }
}