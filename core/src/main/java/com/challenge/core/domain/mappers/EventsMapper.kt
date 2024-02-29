package com.challenge.core.domain.mappers

import com.challenge.core.data.responses.EventResponse
import com.challenge.core.domain.models.City
import com.challenge.core.domain.models.Country
import com.challenge.core.domain.models.Dates
import com.challenge.core.domain.models.Event
import com.challenge.core.domain.models.Images
import com.challenge.core.domain.models.Start
import com.challenge.core.domain.models.State
import com.challenge.core.domain.models.Status
import com.challenge.core.domain.models.Venue

class EventsMapper {

    fun toEvent(eventResponse: EventResponse): Event {
        return Event(
            id = eventResponse.id.orEmpty(),
            name = eventResponse.name.orEmpty(),
            dates = eventResponse.dates?.let { dates ->
                Dates(
                    spanMultipleDays = dates.spanMultipleDays,
                    start = dates.start?.let { start ->
                        Start(
                            start.dateTBA,
                            start.dateTBD,
                            start.dateTime.orEmpty(),
                            start.localDate.orEmpty(),
                            start.localTime.orEmpty(),
                            start.noSpecificTime,
                            start.timeTBA
                        )
                    } ?: Start(),
                    status = Status(dates.status?.code.orEmpty()),
                    timezone = dates.timezone.orEmpty()
                )
            } ?: Dates(),
            images = findBestRatio(eventResponse),
            locale = eventResponse.locale.orEmpty(),
            type = eventResponse.type.orEmpty(),
            url = eventResponse.url.orEmpty(),
            venues = eventResponse.embedded?.venues?.map { venue ->
                Venue(
                    id = venue.id.orEmpty(),
                    name = venue.name.orEmpty(),
                    city = City(name = venue.city?.name.orEmpty()),
                    country = Country(name = venue.country?.name.orEmpty()),
                    state = State(name = venue.state?.name.orEmpty())
                )
            } ?: emptyList()
        )
    }

    private fun findBestRatio(eventResponse: EventResponse): List<Images> {
        return eventResponse.images?.find { it.width >= BEST_WIDTH }?.let { image ->
            listOf(
                Images(
                    fallback = image.fallback,
                    height = image.height,
                    ratio = image.ratio.orEmpty(),
                    url = image.url.orEmpty(),
                    width = image.width
                )
            )
        } ?: emptyList()
    }

    private companion object {
        const val BEST_WIDTH = 640
    }
}