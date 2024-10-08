package com.iclickipay.data.repository.learn

import com.iclickipay.data.model.learn.TeacherDataItemItemModel

interface Repository {
    suspend fun getDetails(): List<TeacherDataItemItemModel>
}