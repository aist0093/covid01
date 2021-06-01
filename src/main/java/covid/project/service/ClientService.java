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
    public List<Client> fetchAll() {
        return clientRepo.fetchAll();
    }

}
