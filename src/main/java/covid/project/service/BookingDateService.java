package covid.project.service;

import covid.project.model.BookingDate;
import covid.project.repo.BookingDateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingDateService implements BookingDateServiceInter {
    @Autowired
    BookingDateRepo bookingDateRepo;

    @Override
    public List<BookingDate> fetchAll() {
        return bookingDateRepo.fetchAll();
    }

    @Override
    public void FindBookingByTime(BookingDate bookingDate) {
        bookingDateRepo.FindBookingByTime(bookingDate);
    }
}
