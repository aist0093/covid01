package covid.project.repo;

import covid.project.model.ClientPage;

import java.util.List;

public interface ClientPageInter {
    List<ClientPage> fetchAll();
}
