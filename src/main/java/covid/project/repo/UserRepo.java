package covid.project.repo;

import covid.project.model.User;
import covid.project.security.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo implements UserInter {

    @Autowired
    JdbcTemplate jdbc;

    @Autowired
    IAuthenticationFacade auth;


    @Override
    public List<User> fetchAll() {
        String sql = "SELECT * FROM users";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return jdbc.query(sql, rowMapper);

    }

    public int getClientID() {
        String sql = "SELECT ClientID from client where cpr = ?";
        return jdbc.queryForObject(
                sql, Integer.class, new Object[]{auth.getAuthentication().getName()});
    }
}
