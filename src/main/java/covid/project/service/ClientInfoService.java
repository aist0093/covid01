package covid.project.service;

import covid.project.model.ClientInfo;
import covid.project.repo.BookingRepo;
import covid.project.repo.ClientInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientInfoService implements ClientInfoServiceInter{

    @Autowired
    ClientInfoRepo clientInfoRepo;

    @Override
    public long addClientInfo(ClientInfo clientInfo) { return clientInfoRepo.addClientInfo(clientInfo); }

    @Override
    public List<ClientInfo> fetchAll() { return clientInfoRepo.fetchAll(); }

    @Override
    public ClientInfo findClientInfoByID(long cpr) { return clientInfoRepo.findClientInfoByID(cpr); }
}
