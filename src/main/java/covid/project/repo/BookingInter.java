package covid.project.repo;

import covid.project.model.Booking;

import java.util.List;

public interface BookingInter {
    public int addBooking(Booking booking);
    public List<Booking> fetchAll();
}
