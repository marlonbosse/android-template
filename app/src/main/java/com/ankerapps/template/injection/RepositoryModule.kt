package com.ankerapps.template.injection

import com.ankerapps.template.data.CounterRepository
import com.ankerapps.template.data.CounterRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun counterRepository(counter: CounterRepositoryImpl): CounterRepository
}
