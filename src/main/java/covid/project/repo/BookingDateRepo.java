package covid.project.repo;

import covid.project.model.BookingDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingDateRepo implements BookingDateInter {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<BookingDate> fetchAll() {
        String sql = "SELECT * FROM bookingdate";
        RowMapper<BookingDate> rowMapper = new BeanPropertyRowMapper<>(BookingDate.class);
        return jdbc.query(sql, rowMapper);
    }


    @Override
    public void FindBookingByTime(BookingDate bookingDate) {
        String sql = "SELECT DateID FROM bookingdate WHERE cast(dateDate as date) = cast(? as date) and cast(timeTime as time) = cast(? as time)";
        int newID = jdbc.queryForObject(sql, Integer.class, new Object[]{bookingDate.getDateDate(), bookingDate.getTimeTime()});
        bookingDate.setDateID(newID);
    }
}
