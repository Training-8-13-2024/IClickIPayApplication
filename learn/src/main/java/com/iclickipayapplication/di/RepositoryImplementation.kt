package com.iclickipayapplication.di

import com.iclickipay.data.model.learn.TeacherDataItemItemModel
import com.iclickipay.data.remote.learn.TeacherApiInterface
import com.iclickipay.data.repository.learn.Repository
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(val apiTeacher: TeacherApiInterface): Repository {
    override suspend fun getDetails(): List<TeacherDataItemItemModel> {
        return apiTeacher.getDetails()
    }
}