package com.iclickipay.data.profile.remote

import com.iclickipay.data.profile.model.ProfileItemModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ProfileApiInterface {
    @GET(ProfileApiDetails.END_POINTS)
    suspend fun getProfiles(
        @Query("results") results: Int = 10,
        @Query("gender") gender: String = "female"): ProfileItemModel
}