package covid.project.repo;

import covid.project.model.Booking;
import java.util.List;

public interface BookingInter {
     int addBooking(Booking booking);
     List<Booking> fetchAll();
     Booking findBookingById(int bookID);
     int updateResult(Booking booking);
}
