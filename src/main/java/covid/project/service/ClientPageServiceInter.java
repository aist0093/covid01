package covid.project.service;

import covid.project.model.ClientPage;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClientPageServiceInter {
    List<ClientPage> fetchAll();
}
