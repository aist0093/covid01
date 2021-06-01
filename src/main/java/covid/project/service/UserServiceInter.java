package covid.project.service;

import covid.project.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserServiceInter {
    User findUserByUsername(String username);

    List<User> fetchAll();

    int getClientID();

}
