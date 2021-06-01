package covid.project.repo;

import covid.project.model.BookingDate;

import java.util.List;

public interface   BookingDateInter {
    List<BookingDate> fetchAll();
    void FindBookingByTime(BookingDate bookingDate);
}
