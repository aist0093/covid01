package covid.project.repo;

import covid.project.model.Booking;
import covid.project.model.BookingDate;
import covid.project.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

public interface BookingInter {
     int addBooking(Booking booking, BookingDate bookingDate);
     List<Booking> fetchAll();
     Booking findBookingById(int bookID);
     int delete(int bookID);
}
