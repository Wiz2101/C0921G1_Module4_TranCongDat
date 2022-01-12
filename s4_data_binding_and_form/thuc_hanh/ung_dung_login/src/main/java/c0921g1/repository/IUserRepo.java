package c0921g1.repository;

import c0921g1.model.Login;
import c0921g1.model.User;

public interface IUserRepo {
    public User checkLogin(Login login);
}
