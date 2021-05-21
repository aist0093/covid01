package covid.project.service;

import covid.project.model.Booking;
import covid.project.model.ClientInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClientInfoServiceInter {
    public long addClientInfo(ClientInfo clientInfo);
    public List<ClientInfo> fetchAll();
    public ClientInfo findClientInfoByID(long cpr);
}
