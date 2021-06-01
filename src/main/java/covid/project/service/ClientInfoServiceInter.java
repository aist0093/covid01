package covid.project.service;

import covid.project.model.ClientInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClientInfoServiceInter {

    List<ClientInfo> fetchAll();

}
