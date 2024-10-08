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