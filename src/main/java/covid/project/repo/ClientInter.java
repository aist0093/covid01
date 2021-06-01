package covid.project.repo;

import covid.project.model.Client;

import java.util.List;

public interface ClientInter {
    List<Client> fetchAll();
}
