package covid.project.service;

import covid.project.model.Booking;
import covid.project.model.BookingDate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookingDateServiceInter {
    public long addBookingDate(BookingDate bookingDate);
    public List<BookingDate> fetchAll();
    public BookingDate findBookingDateById(int dateID);
}
