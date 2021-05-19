package covid.project.service;

import covid.project.model.Booking;
import covid.project.repo.BookingInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookingService implements BookingServiceInter {
    BookingInter bookingInter;
    public int addBooking(Booking booking) {
        return bookingInter.addBooking(booking);
    }
    public List<Booking> fetchAll() {
        return bookingInter.fetchAll();
    }
    public Booking findBookingById(int bookID){return bookingInter.findBookingById(bookID);}
}