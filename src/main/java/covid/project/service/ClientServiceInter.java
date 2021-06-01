package covid.project.service;

import covid.project.model.Client;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClientServiceInter {
    long addClient(Client client);

    List<Client> fetchAll();

    Client findClientByID(long clientID);
}
