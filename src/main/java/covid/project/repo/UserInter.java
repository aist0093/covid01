package covid.project.repo;

import covid.project.model.User;

import java.util.List;

public interface UserInter {
    User findUserByUsername(String username);
    List<User> fetchAll();
    int getClientID();

}
