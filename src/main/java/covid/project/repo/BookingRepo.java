package covid.project.repo;

import covid.project.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BookingRepo implements BookingInter{

    @Autowired
    JdbcTemplate template;
    @Override
    public int addBooking(Booking booking) {
        String sql = "INSERT INTO booking VALUES(?,?,?,?,?)";
        return template.update(sql,null, 1, "Vaccine", null, 1 );
    }

    @Override
    public List<Booking> fetchAll() {
        String sql = "SELECT * FROM booking";
        RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);
        return template.query(sql, rowMapper);
    }

    @Override
    public Booking findBookingById(int bookID){
        String sql = "SELECT * FROM booking WHERE BookID = ?";
        RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);
        Booking booking = template.queryForObject(sql, rowMapper, bookID);
        return booking;
    }
}
