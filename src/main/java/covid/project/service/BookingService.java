package covid.project.service;

import covid.project.model.Booking;
import covid.project.repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookingService implements BookingServiceInter {
    @Autowired
    BookingRepo repo;

    @Override
    public int addBooking(Booking booking) {
        return repo.addBooking(booking);
    }
    @Override
    public List<Booking> fetchAll() {
        return repo.fetchAll();
    }
    @Override
    public Booking findBookingById(int bookID) {
        return repo.findBookingById(bookID);
    }

    @Override
    public int updateResult(Booking booking) {
        return repo.updateResult(booking);
    }
}