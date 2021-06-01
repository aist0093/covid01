package covid.project.repo;

import covid.project.model.ClientInfo;

import java.util.List;

public interface ClientInfoInter {

    List<ClientInfo> fetchAll();

}
