package id.hendra.e_mydiabetes.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.hendra.e_mydiabetes.helper.DatastoreManager
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object AppModule {
    @Provides
    @Singleton
    fun provideDataStoreManager(app: Application): DatastoreManager {
        return DatastoreManager(app)
    }

}