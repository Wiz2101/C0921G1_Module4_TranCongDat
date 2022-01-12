package c0921g1.service;

import c0921g1.model.Login;
import c0921g1.model.User;
import c0921g1.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepo userRepo;

    @Override
    public User checkLogin(Login login) {
        return userRepo.checkLogin(login);
    }
}
