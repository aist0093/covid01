package covid.project.service;

import covid.project.model.Booking;
import covid.project.model.BookingDate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookingServiceInter {

    public int addBooking(Booking booking, BookingDate bookingDate);
    public List<Booking> fetchAll();
    public Booking findBookingById(int bookID);
    public int updateResult(Booking booking);
}
