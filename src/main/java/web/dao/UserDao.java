package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List getAllUsers();
    User getUserById(Long id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserById(Long id);
}
