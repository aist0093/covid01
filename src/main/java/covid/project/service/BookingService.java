package covid.project.service;

import covid.project.model.Booking;
import covid.project.repo.BookingInter;
import covid.project.repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookingService implements BookingServiceInter {
    @Autowired
    BookingRepo bookingRepo;

    @Override
    public int addBooking(Booking booking) {
        return bookingRepo.addBooking(booking);
    }
    @Override
    public List<Booking> fetchAll() {
        return bookingRepo.fetchAll();
    }
    @Override
    public Booking findBookingById(int bookID){return bookingRepo.findBookingById(bookID);}
}