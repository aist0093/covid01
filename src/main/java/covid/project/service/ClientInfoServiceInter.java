package covid.project.service;

import covid.project.model.ClientInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClientInfoServiceInter {
    long addClientInfo(ClientInfo clientInfo);

    List<ClientInfo> fetchAll();

    ClientInfo findClientInfoByID(long cpr);
}
