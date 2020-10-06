package com.gmail.maystruks08.filmviewer.core.di

import com.gmail.maystruks08.data.repository.SyncRunnersDataScheduler
import com.gmail.maystruks08.filmviewer.core.di.host.HostScope
import com.gmail.maystruks08.filmviewer.workers.SyncRunnersWorkHelper
import dagger.Binds
import dagger.Module

@Module
abstract class SyncModule {

    @Binds
    @HostScope
    abstract fun provideSyncRunnersDataScheduler(syncRunnersWorkHelper: SyncRunnersWorkHelper): SyncRunnersDataScheduler

}