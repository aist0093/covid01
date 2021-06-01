package covid.project.repo;

import covid.project.model.BookingDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class BookingDateRepo implements BookingDateInter {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public int addBookingDate(BookingDate bookingDate) {
        String sql = "INSERT into bookingdate (dateDate, timeTime) values(?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(
                connection -> {
                    PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
                    ps.setDate(1, java.sql.Date.valueOf(bookingDate.getDateDate()));
                    ps.setTime(2, java.sql.Time.valueOf(bookingDate.getTimeTime()));
                    return ps;
                }, keyHolder);
        bookingDate.setDateID(keyHolder.getKey().intValue());
        return keyHolder.getKey().intValue();
    }


    @Override
    public List<BookingDate> fetchAll() {
        String sql = "SELECT * FROM bookingdate";
        RowMapper<BookingDate> rowMapper = new BeanPropertyRowMapper<>(BookingDate.class);
        return jdbc.query(sql, rowMapper);
    }

    @Override
    public BookingDate findBookingDateById(int dateID) {
        String sql = "SELECT * FROM bookingdate WHERE DateID = ?";
        RowMapper<BookingDate> rowMapper = new BeanPropertyRowMapper<>(BookingDate.class);
        BookingDate bookingDate = jdbc.queryForObject(sql, rowMapper, dateID);
        return bookingDate;
    }

    @Override
    public void FindBookingByTime(BookingDate bookingDate) {
        String sql = "SELECT DateID FROM bookingdate WHERE cast(dateDate as date) = cast(? as date) and cast(timeTime as time) = cast(? as time)";
        int newID = jdbc.queryForObject(sql, Integer.class, new Object[]{bookingDate.getDateDate(), bookingDate.getTimeTime()});
        bookingDate.setDateID(newID);
    }
}
