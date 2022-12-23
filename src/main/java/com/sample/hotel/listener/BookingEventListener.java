package com.sample.hotel.listener;

import com.sample.hotel.app.BookingService;
import com.sample.hotel.entity.Booking;
import io.jmix.core.event.EntityChangedEvent;
import io.jmix.core.event.EntitySavingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

@Component
public class BookingEventListener {

    @Autowired
    BookingService bookingService;

    @EventListener
    public void onBookingSaving(EntitySavingEvent<Booking> event) {
        Booking booking = event.getEntity();

        booking.setDepartureDate(booking.getArrivalDate().plusDays(booking.getNightsOfStay()));
    }

    @EventListener
    public void onBookingChangedAfterCommit(EntityChangedEvent<Booking> event) {
        bookingService.deleteRoomReservation(event.getEntityId());
    }
}