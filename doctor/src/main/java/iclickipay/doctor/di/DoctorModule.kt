package iclickipay.doctor.di


import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DoctorModule {

//DoctorModule    // Provide the DAO
//    @Provides
//    fun providePatientDao(database: AppDatabase) = database.PatientDao()



}
