package com.sample.hotel.app;

import com.sample.hotel.entity.Booking;
import com.sample.hotel.entity.Room;
import com.sample.hotel.entity.RoomReservation;
import org.springframework.stereotype.Component;

@Component
public class BookingService {

    /**
     * Check if given room is suitable for the booking.
     * 1) Check that sleeping places is enough to fit numberOfGuests.
     * 2) Check that there are no reservations for this room at the same range of dates.
     * Use javax.persistence.EntityManager and JPQL query for querying database.
     *
     * @param booking booking
     * @param room room
     * @return true if checks are passed successfully
     */
    public boolean isSuitable(Booking booking, Room room) {
        //todo implement me!
        return true;
    }

    /**
     * Check that room is suitable for the booking, and create a reservation for this room.
     * @param room room to reserve
     * @param booking hotel booking
     * Wrap operation into a transaction (declarative or manual).
     *
     * @return created reservation object, or null if room is not suitable
     */
    public RoomReservation reserveRoom(Booking booking, Room room) {
        //todo implement me!
        return null;
    }
}