package com.iclickipay.data.repository.learn

import com.iclickipay.data.model.learn.TeacherDataItemItemModel
import com.iclickipay.data.model.tinder.ProductsModelItemModel

interface Repository {
    suspend fun getDetails(): List<ProductsModelItemModel>
    suspend fun getDetailsTeacher(): List<TeacherDataItemItemModel>
}