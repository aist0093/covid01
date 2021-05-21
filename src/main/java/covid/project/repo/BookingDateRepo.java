package covid.project.repo;

import covid.project.model.Booking;
import covid.project.model.BookingDate;
import covid.project.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingDateRepo implements BookingDateInter{

    @Autowired
    JdbcTemplate template;
    @Override
    public long addBookingDate(BookingDate bookingDate) {
        String sql = "INSERT INTO bookingdate VALUES(?,?,?)";
        return template.update(sql, 1, 2022-01-01, 1);
    }

    @Override
    public List<BookingDate> fetchAll() {
        String sql = "SELECT * FROM bookingdate";
        RowMapper<BookingDate> rowMapper = new BeanPropertyRowMapper<>(BookingDate.class);
        return template.query(sql, rowMapper);
    }

    @Override
    public BookingDate findBookingDateByID(int DateID) {
        String sql = "SELECT * FROM bookingdate WHERE DateID = ?";
        RowMapper<BookingDate> rowMapper = new BeanPropertyRowMapper<>(BookingDate.class);
        BookingDate bookingDate = template.queryForObject(sql, rowMapper, DateID);
        return bookingDate;
    }
}
