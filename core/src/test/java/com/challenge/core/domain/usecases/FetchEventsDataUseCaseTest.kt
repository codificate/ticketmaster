package com.challenge.core.domain.usecases

import com.appmattus.kotlinfixture.decorator.nullability.NeverNullStrategy
import com.appmattus.kotlinfixture.decorator.nullability.nullabilityStrategy
import com.appmattus.kotlinfixture.decorator.optional.NeverOptionalStrategy
import com.appmattus.kotlinfixture.decorator.optional.optionalStrategy
import com.appmattus.kotlinfixture.kotlinFixture
import com.challenge.core.data.common.ApiState
import com.challenge.core.data.responses.EmbeddedResponse
import com.challenge.core.data.responses.EventResponse
import com.challenge.core.data.responses.TMResponse
import com.challenge.core.domain.mappers.EventsMapper
import com.challenge.core.domain.models.Event
import com.challenge.core.domain.repository.TicketMasterApiRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

class FetchEventsDataUseCaseTest {

    private val fixtures = kotlinFixture {
        nullabilityStrategy(NeverNullStrategy)
        optionalStrategy(NeverOptionalStrategy)
    }

    private lateinit var fetchEventsDataUseCase: FetchEventsDataUseCase

    private val repository = mockk<TicketMasterApiRepository>()

    private val mapper = mockk<EventsMapper>()

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        fetchEventsDataUseCase = FetchEventsDataUseCase(mapper, repository, testDispatcher)
    }

    @Test
    fun `invoke with valid eventName returns expected events`() = runTest {
        // Given
        val eventName = "Event name"
        val event = fixtures<Event>()
        val tmResponse = mockk<TMResponse>()
        val expectedEvents = listOf(event)
        val mockApiStateFlow = flowOf(ApiState.Success(tmResponse))
        coEvery { repository.fetchEvents(any()) } returns mockApiStateFlow
        every { mapper.toEvent(any()) } returns expectedEvents[0]

        // When
        val resultFlow = fetchEventsDataUseCase.invoke(eventName)

        // Then
        val resultEvents = resultFlow.single()
        assertEquals(expectedEvents, resultEvents)
    }
}