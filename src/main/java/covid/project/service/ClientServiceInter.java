package covid.project.service;

import covid.project.model.Client;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClientServiceInter {

    List<Client> fetchAll();

}
