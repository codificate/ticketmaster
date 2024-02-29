package com.challenge.core.di.usecases

import com.challenge.core.domain.mappers.EventsMapper
import com.challenge.core.domain.repository.TicketMasterApiRepository
import com.challenge.core.domain.usecases.FetchEventsDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object EventsUseCaseModule {

    @Provides
    @Singleton
    fun provideEventMapper() = EventsMapper()

    @Provides
    @Singleton
    fun providesUseCase(mapper: EventsMapper, repository: TicketMasterApiRepository) =
        FetchEventsDataUseCase(mapper, repository)
}