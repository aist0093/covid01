package covid.project.repo;

import covid.project.model.ClientInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientInfoRepo implements ClientInfoInter {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<ClientInfo> fetchAll() {
        String sql = "SELECT * FROM clientinfo";
        RowMapper<ClientInfo> rowMapper = new BeanPropertyRowMapper<>(ClientInfo.class);
        return jdbc.query(sql, rowMapper);
    }

}
