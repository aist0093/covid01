package covid.project.repo;

import covid.project.model.Client;

import java.util.List;

public interface ClientInter {
    long addClient(Client client);
    List<Client> fetchAll();
    Client findClientByID(long clientID);
}
