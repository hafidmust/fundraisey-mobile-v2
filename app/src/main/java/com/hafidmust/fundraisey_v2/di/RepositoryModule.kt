package com.hafidmust.fundraisey_v2.di

import com.hafidmust.fundraisey_v2.data.repository.AuthRepositoryImpl
import com.hafidmust.fundraisey_v2.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideAuthRepository(authRepositoryImpl: AuthRepositoryImpl) : AuthRepository

}