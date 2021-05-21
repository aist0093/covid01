package covid.project.repo;

import covid.project.model.Client;
import covid.project.model.ClientInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepo implements ClientInter {

    @Autowired
    JdbcTemplate template;
    @Override
    public long addClient(Client client) {
        String sql = "INSERT INTO client VALUES(?,?,?,?)";
        return template.update(sql, 1, 1, 1,1 );
    }

    @Override
    public List<Client> fetchAll() {
        String sql = "SELECT * FROM client";
        RowMapper<Client> rowMapper = new BeanPropertyRowMapper<>(Client.class);
        return template.query(sql, rowMapper);
    }

    @Override
    public Client findClientByID(long clientID) {
        String sql = "SELECT * FROM client WHERE ClientID = ?";
        RowMapper<Client> rowMapper = new BeanPropertyRowMapper<>(Client.class);
        Client client = template.queryForObject(sql, rowMapper, clientID);
        return client;
    }
}
