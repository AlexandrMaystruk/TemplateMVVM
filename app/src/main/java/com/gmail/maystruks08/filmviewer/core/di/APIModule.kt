package com.gmail.maystruks08.filmviewer.core.di

import com.gmail.maystruks08.data.remote.DefaultApi
import com.gmail.maystruks08.data.remote.DefaultApiImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class APIModule {

    @Binds
    @Singleton
    abstract fun provideDefaultApi(defaultApiImpl: DefaultApiImpl): DefaultApi

}