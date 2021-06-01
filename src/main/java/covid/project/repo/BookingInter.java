package covid.project.repo;

import covid.project.model.Booking;
import covid.project.model.BookingDate;

import java.util.List;

public interface BookingInter {
     int addBooking(Booking booking, BookingDate bookingDate);
     List<Booking> fetchAll();
     Booking findBookingById(int bookID);
     int delete(int bookID);
}
