package covid.project.service;

import covid.project.model.BookingDate;
import covid.project.model.User;
import covid.project.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements UserServiceInter{
    @Autowired
    UserRepo userRepo;

    @Override
    public User findUserByUsername(String username) {
        return userRepo.findUserByUsername(username);
    }

    @Override
    public List<User> fetchAll() {
        return userRepo.fetchAll();
    }


}
