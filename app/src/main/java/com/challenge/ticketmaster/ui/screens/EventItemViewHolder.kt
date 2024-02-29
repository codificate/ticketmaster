package com.challenge.ticketmaster.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.challenge.core.domain.models.Event
import com.challenge.ticketmaster.R
import com.challenge.ticketmaster.databinding.EventItemBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

class EventItemViewHolder(private val binding: EventItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun binding(event: Event) {
        binding.itemEventTitle.text = event.name
        displayImage(event.images.firstOrNull()?.url ?: "")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            val dateFormatted = LocalDate.parse(event.dates.start.localDate, formatter)
            val month = dateFormatted.month.name
            val day = dateFormatted.dayOfMonth
            binding.itemDate.text = binding.root.context.resources.getString(
                R.string.event_venue_date,
                month,
                day.toString()
            )
        } else {
            binding.itemDate.text = event.dates.start.localDate
        }
        if (event.venues.isNotEmpty()) {
            event.venues.first().let { venue ->
                binding.itemVenue.text = venue.name
                binding.itemCity.text = binding.root.context.resources.getString(
                    R.string.event_venue_city,
                    venue.city.name,
                    venue.state.name
                )
            }
        }
    }

    private fun displayImage(image: String) =
        binding.itemPicture.load(image) {
            crossfade(true)
            placeholder(R.drawable.ic_image_placeholder)
        }
}