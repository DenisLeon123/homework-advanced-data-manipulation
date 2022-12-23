package com.sample.hotel.app;

import com.sample.hotel.entity.Booking;
import com.sample.hotel.entity.Room;
import com.sample.hotel.entity.RoomReservation;
import io.jmix.core.DataManager;
import io.jmix.core.Id;
import io.jmix.core.Metadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

@Component
public class BookingService {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private Metadata metadata;
    @Autowired
    private DataManager dataManager;

    /**
     * Check if given room is suitable for the booking.
     * 1) Check that sleeping places is enough to fit numberOfGuests.
     * 2) Check that there are no reservations for this room at the same range of dates.
     * Use javax.persistence.EntityManager and JPQL query for querying database.
     *
     * @param booking booking
     * @param room    room
     * @return true if checks are passed successfully
     */
    @Transactional
    public boolean isSuitable(Booking booking, Room room) {

        int firstresult = entityManager
                .createNativeQuery("select r.id\n" +
                        " from room r\n" +
                        " left join room_reservation rr on r.id = rr.room_id\n" +
                        " left join booking b on rr.booking_id = b.id\n" +
                        " where \n" +
                        "\t(r.id = ?1\n" +
                        "\tand r.sleeping_Places > ?2\n" +
                        "\tand ((?3 not between b.arrival_Date and b.departure_Date) and (?4 not between b.arrival_Date and b.departure_Date)))" +
                        " or (r.id = ?1 and rr.room_id is null)")
                .setParameter(1, room.getId())
                .setParameter(2, booking.getNumberOfGuests())
                .setParameter(3, booking.getArrivalDate())
                .setParameter(4, booking.getDepartureDate())
                .getResultList().size();

        return firstresult > 0;
    }

    /**
     * Check that room is suitable for the booking, and create a reservation for this room.
     *
     * @param room    room to reserve
     * @param booking hotel booking
     *                Wrap operation into a transaction (declarative or manual).
     * @return created reservation object, or null if room is not suitable
     */

    @Transactional
    public RoomReservation reserveRoom(Booking booking, Room room) {

        if (isSuitable(booking, room)) {
            RoomReservation roomReservation = metadata.create(RoomReservation.class);
            roomReservation.setRoom(room);
            roomReservation.setBooking(booking);

            entityManager.persist(roomReservation);

            return roomReservation;
        }

        return null;
    }

    public void deleteRoomReservation(Id<Booking> id) {
        Booking booking = dataManager
                .load(Booking.class)
                .id(id)
                .one();

        RoomReservation roomReservation = booking.getRoomReservation();

        if (roomReservation != null) {
            entityManager.remove(roomReservation);
        }
    }
}