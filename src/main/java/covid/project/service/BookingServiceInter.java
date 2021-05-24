package covid.project.service;

import covid.project.model.Booking;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookingServiceInter {

    public int addBooking(Booking booking);
    public List<Booking> fetchAll();
    public Booking findBookingById(int bookID);
    public int updateResult(Booking booking);
}
