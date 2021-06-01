package covid.project.service;


import covid.project.model.BookingDate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookingDateServiceInter {
    int addBookingDate(BookingDate bookingDate);

    List<BookingDate> fetchAll();

    BookingDate findBookingDate(int dateID);

    void FindBookingByTime(BookingDate bookingDate);
}
