package covid.project.service;

import covid.project.model.ClientInfo;
import covid.project.repo.ClientInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientInfoService implements ClientInfoServiceInter {

    @Autowired
    ClientInfoRepo clientInfoRepo;


    @Override
    public List<ClientInfo> fetchAll() {
        return clientInfoRepo.fetchAll();
    }
}
