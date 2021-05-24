package covid.project.repo;


import covid.project.model.ClientPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ClientPageRepo implements ClientPageInter{

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<ClientPage> fetchAll() {
        String sql = "SELECT\n" +
                "    concat(c2.first_name,' ',c2.last_name) as 'full_name',\n" +
                "    c.cpr,\n" +
                "    b.type,\n" +
                "    b.result,\n" +
                "    concat(b2.dateDate,' ', b2.timeTime) as 'date'\n" +
                "from booking b\n" +
                "join client c on c.ClientID = b.ClientID\n" +
                "join clientinfo c2 on c2.cpr = c.CPR\n" +
                "join bookingdate b2 on b2.DateID = b.DateID";
        RowMapper<ClientPage> rowMapper = new BeanPropertyRowMapper<>(ClientPage.class);
        return jdbc.query(sql, rowMapper);
    }
}
