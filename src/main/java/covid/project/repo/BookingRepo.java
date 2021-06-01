package covid.project.repo;

import covid.project.model.Booking;
import covid.project.model.BookingDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.time.LocalTime;
import java.util.List;

@Repository
public class BookingRepo implements BookingInter {

    @Autowired
    JdbcTemplate jdbc;

    @Override

    public int addBooking(Booking booking, BookingDate bookingDate) {
        System.out.println(bookingDate.getTimeTime());
        String sql = "INSERT INTO booking ( Type, Result, DateID, ClientID) VALUES (?,?,(SELECT DateID FROM bookingdate WHERE cast(dateDate as date) = cast(? as date) and cast(timeTime as time) = cast(? as time)),?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(
                connection -> {
                    PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
                    ps.setString(1, booking.getType());
                    ps.setBoolean(2, booking.isResult());
                    ps.setDate(3, java.sql.Date.valueOf(bookingDate.getDateDate()));
                    ps.setTime(4, java.sql.Time.valueOf(LocalTime.parse(bookingDate.getTimeTime())));
                    ps.setInt(5, booking.getClientID());
                    return ps;
                }, keyHolder);
        booking.setBookID(keyHolder.getKey().intValue());
        return keyHolder.getKey().intValue();

    }

    @Override
    public List<Booking> fetchAll() {
        String sql = "SELECT * FROM booking";
        RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);
        return jdbc.query(sql, rowMapper);
    }

    @Override
    public Booking findBookingById(int bookID) {
        String sql = "SELECT * FROM booking WHERE BookID = ?";
        RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);
        Booking booking = jdbc.queryForObject(sql, rowMapper, bookID);
        return booking;
    }

    public int updateResult(Booking booking) {
        String sql = "Update booking SET Result = ? WHERE BookID = ?";
        return jdbc.update(sql, booking.isResult(), booking.getBookID());
    }

    public int delete(int bookID) {
        String sql = "DELETE FROM booking WHERE BookID=?";
        return jdbc.update(sql, bookID);
    }
}
