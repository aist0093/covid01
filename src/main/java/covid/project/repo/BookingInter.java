package covid.project.repo;

import covid.project.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

public interface BookingInter {
    public int addBooking(Booking booking);
    public List<Booking> fetchAll();
    public Booking findBookingById(int bookID);
}