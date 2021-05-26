package covid.project.repo;

import covid.project.model.Booking;
import covid.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserRepo implements UserInter{

    @Autowired
    JdbcTemplate template;

    @Override
    public User findUserByUsername(String username){
        String sql = "SELECT * FROM users WHERE username = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        User user = template.queryForObject(sql, rowMapper, username);
        return user;
    }

    @Override
    public List<User> fetchAll() {
        String sql = "SELECT * FROM users";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return template.query(sql, rowMapper);

    }
}
