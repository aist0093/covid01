package covid.project.service;


import covid.project.model.BookingDate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookingDateServiceInter {
    public List<BookingDate> fetchAll();
    public BookingDate findBookingDate(int dateID);
}
