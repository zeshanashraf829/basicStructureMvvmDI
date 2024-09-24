package com.getgoally.learnerapp.di

import android.content.Context
import androidx.room.Room
import com.android.goally.data.db.AppDatabase
import com.android.goally.data.db.dao.GeneralDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideAppDb(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext, AppDatabase::class.java, AppDatabase.DATABASE_NAME
        )
            .addCallback(AppDatabase.rdc)
//            .addMigrations(
//                MIGRATION_1_2
//            )
//            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideGeneralDao(appDatabase: AppDatabase): GeneralDao {
        return appDatabase.getGeneralDao()
    }
}
