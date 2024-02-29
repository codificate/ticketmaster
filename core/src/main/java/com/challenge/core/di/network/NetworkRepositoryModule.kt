package com.challenge.core.di.network

import com.challenge.core.data.repository.TicketMasterApiRepositoryImpl
import com.challenge.core.data.service.TicketMasterApiService
import com.challenge.core.domain.repository.TicketMasterApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkRepositoryModule {

    @Provides
    @Singleton
    fun providesNetworkRepository(apiService: TicketMasterApiService): TicketMasterApiRepository =
        TicketMasterApiRepositoryImpl(apiService)

}