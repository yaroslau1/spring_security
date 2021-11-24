package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

public interface UserDao {
    List getAllUsers();
    User getUserById(Long id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserById(Long id);
    User findUserByName(String name);
}
