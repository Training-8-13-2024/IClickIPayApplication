package com.iclickipay.data.remote.learn


import com.iclickipay.data.model.learn.TeacherDataItemItemModel
import retrofit2.http.GET

interface TeacherApiInterface {
    @GET(TeacherApiDetails.END_POINTS)
    suspend fun getDetails(): List<TeacherDataItemItemModel>
}