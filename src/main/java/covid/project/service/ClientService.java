package covid.project.service;

import covid.project.model.Client;
import covid.project.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements ClientServiceInter {
    @Autowired
    ClientRepo clientRepo;

    @Override
    public long addClient(Client client) {
        return clientRepo.addClient(client);
    }

    @Override
    public List<Client> fetchAll() {
        return clientRepo.fetchAll();
    }

    @Override
    public Client findClientByID(long clientID) {
        return clientRepo.findClientByID(clientID);
    }
}
