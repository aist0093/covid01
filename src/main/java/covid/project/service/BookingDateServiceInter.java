package covid.project.service;


import covid.project.model.BookingDate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookingDateServiceInter {
    int addBookingDate(BookingDate bookingDate);
    public List<BookingDate> fetchAll();
    public BookingDate findBookingDate(int dateID);
    public void FindBookingByTime(BookingDate bookingDate);
}
