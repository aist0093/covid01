package covid.project.repo;

import covid.project.model.ClientInfo;

import java.util.List;

public interface ClientInfoInter {

    long addClientInfo(ClientInfo clientInfo);
    List<ClientInfo> fetchAll();
    ClientInfo findClientInfoByID(long cpr);
}
