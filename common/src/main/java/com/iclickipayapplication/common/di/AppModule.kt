package com.iclickipayapplication.common.di

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.iclickipay.data.doctor.local.dao.PatientDao
import com.iclickipay.data.learn.local.dao.TeacherBookingDao
import com.iclickipay.data.remote.learn.TeacherApiDetails.BASE_URL
import com.iclickipay.data.remote.learn.TeacherApiInterface
import com.iclickipay.data.remote.tinder.ProductAPIInterface
import com.iclickipay.data.repository.learn.Repository
import com.iclickipay.data.tinder.local.dao.TinderBookingDao
import com.iclickipayapplication.common.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Service1
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Service2

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
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

    @Service1
    @Provides
    fun getRetrofitLearn(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://freetestapi.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }


    @Service2
    @Provides
    fun getRetrofitTinder(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    fun TeacherApiInterface(
        @Service1 retrofit: Retrofit
    ): TeacherApiInterface {
        return retrofit.create(TeacherApiInterface::class.java)

    }



    @Provides
    fun ProductAPIInterface(
        @Service2 retrofit: Retrofit
    ): ProductAPIInterface {
        return retrofit.create(ProductAPIInterface::class.java)

    }

    @Provides
    fun getRepositoryTinder(
        apiHero: ProductAPIInterface,
        apiTeacher: TeacherApiInterface
    ): Repository {
        return RepositoryImplementation(
            apiHero = apiHero,
            apiTeacher = apiTeacher)

    }

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getDatabase(context)
    }

    @Provides
    fun provideBookingDao(db: AppDatabase): TeacherBookingDao {
        return db.teacherBookingDao()
    }

    @Provides
    fun provideTinder(db: AppDatabase): TinderBookingDao {
        return db.tinderDao()
    }

}