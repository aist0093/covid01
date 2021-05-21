package covid.project.repo;


import covid.project.model.Booking;
import covid.project.model.BookingDate;
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
    public List<BookingDate> fetchAll() {
        String sql = "SELECT * FROM bookingdate";
        RowMapper<BookingDate> rowMapper = new BeanPropertyRowMapper<>(BookingDate.class);
        return template.query(sql, rowMapper);
    }

    @Override
    public BookingDate findBookingDateById(int dateID){
        String sql = "SELECT * FROM bookingdate WHERE DateID = ?";
        RowMapper<BookingDate> rowMapper = new BeanPropertyRowMapper<>(BookingDate.class);
        BookingDate bookingDate = template.queryForObject(sql, rowMapper, dateID);
        return bookingDate;
    }
}
