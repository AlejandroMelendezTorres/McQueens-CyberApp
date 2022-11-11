package com.example.ademanos_android_app.services.modules

import com.example.ademanos_android_app.services.AuthService
import com.example.ademanos_android_app.services.impl.AuthServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {
    @Binds abstract fun provideAuthService(impl: AuthServiceImpl): AuthService
}