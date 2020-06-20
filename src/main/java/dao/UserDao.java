package dao;

import domain.User;

public interface UserDao {
    User findUserByUsername(String username);
    void save(User user);
    User findUserByCode(String code);
    void upDateStatus(User user);
    User findUserByLoginInfo(User user);
}
