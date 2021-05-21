package covid.project.repo;

import covid.project.model.BookingDate;


import java.util.List;

public interface BookingDateInter {
    long addBookingDate(BookingDate bookingDate);
    List<BookingDate> fetchAll();
    BookingDate findBookingDateByID(int DateID);
}
