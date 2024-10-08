package com.iclickipayapplication.di

import com.google.gson.Gson
import com.iclickipay.data.remote.tinder.ProductAPIDetails.BASE_URL
import com.iclickipay.data.remote.tinder.ProductAPIInterface
import com.iclickipay.data.repository.tinder.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class TinderModule {
    @Provides
    fun getGson(): Gson { //return type is how the hilt will know what to return
        //Function Name itself serves No purpose
        return Gson()
    }

    @Provides
    fun getHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }


    @Provides
    fun getRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    fun ProductAPIInterface(
        retrofit: Retrofit
    ): ProductAPIInterface {
        return retrofit.create(ProductAPIInterface::class.java)

    }

    @Provides
    fun getRepository(
        apiHero: ProductAPIInterface
    ): Repository {
        return RepositoryImplementation(apiHero)

    }
}