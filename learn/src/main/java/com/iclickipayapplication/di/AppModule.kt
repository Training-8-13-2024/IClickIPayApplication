package com.iclickipayapplication.di

import com.google.gson.Gson
import com.iclickipay.data.remote.learn.TeacherApiDetails.BASE_URL
import com.iclickipay.data.remote.learn.TeacherApiInterface
import com.iclickipay.data.repository.learn.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun getRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    fun TeacherApiInterface(
        retrofit: Retrofit
    ): TeacherApiInterface {
        return retrofit.create(TeacherApiInterface::class.java)

    }

    @Provides
    fun getRepository(
        apiTeacher: TeacherApiInterface
    ): Repository {
        return RepositoryImplementation(apiTeacher)

    }
}