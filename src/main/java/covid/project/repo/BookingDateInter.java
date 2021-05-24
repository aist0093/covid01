package covid.project.repo;

import covid.project.model.Booking;
import covid.project.model.BookingDate;

import java.util.List;

public interface   BookingDateInter {
    int addBookingDate(BookingDate bookingDate);
    List<BookingDate> fetchAll();
    BookingDate findBookingDateById(int dateID);
    public void FindBookingByTime(BookingDate bookingDate);
}
