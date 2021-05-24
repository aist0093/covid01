package covid.project.service;

import covid.project.model.ClientPage;
import covid.project.repo.ClientPageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientPageService implements ClientPageServiceInter{
    @Autowired
    ClientPageRepo repo;
    @Override
    public List<ClientPage> fetchAll() {
        return repo.fetchAll();
    }
}
