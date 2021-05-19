package covid.project.repo;

import covid.project.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

public interface BookingInter {
     int addBooking(Booking booking);
     List<Booking> fetchAll();
     Booking findBookingById(int bookID);
}
