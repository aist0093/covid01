package covid.project.repo;

import covid.project.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepo implements ClientInter {

    @Autowired
    JdbcTemplate jdbc;


    @Override
    public List<Client> fetchAll() {
        String sql = "SELECT * FROM client";
        RowMapper<Client> rowMapper = new BeanPropertyRowMapper<>(Client.class);
        return jdbc.query(sql, rowMapper);
    }
}
