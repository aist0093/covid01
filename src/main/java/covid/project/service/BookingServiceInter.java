package covid.project.service;

import covid.project.model.Booking;
import covid.project.model.BookingDate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookingServiceInter {

    int addBooking(Booking booking, BookingDate bookingDate);

    List<Booking> fetchAll();

    Booking findBookingById(int bookID);

    int updateResult(Booking booking);

    int delete(int bookID);
}
