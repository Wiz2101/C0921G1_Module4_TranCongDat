package c0921g1.service;

import c0921g1.model.Login;
import c0921g1.model.User;

public interface IUserService {
    public User checkLogin(Login login);
}
