package covid.project.repo;

import covid.project.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BookingRepo implements BookingInter{

    @Autowired
    JdbcTemplate template;
    private final String table = "booking";
    @Override
    public int addBooking(Booking booking) {
        String sql = "INSERT INTO " + table + " VALUES(?,?,?,?,?)";
        return template.update(sql,null, clientmethod, "Vaccine", null, datemethod );
    }

    @Override
    public List<Booking> fetchAll() {
        return null;
    }
}
