package iclickipay.doctor.di


import android.content.Context
import androidx.room.Room
import com.iclickipayapplication.common.local.AppDatabase
import com.iclickipayapplication.common.local.dao.PatientDao
import com.iclickipayapplication.common.repository.RepoImpl
import com.iclickipayapplication.common.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    // Provide the Room database instance
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "App_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    // Provide the DAO
    @Provides
    fun providePatientDao(database: AppDatabase) = database.PatientDao()


    // Provide the repository
    @Provides
    fun provideRepository(dao: PatientDao) : Repository {
        return RepoImpl(dao)
    }


}
