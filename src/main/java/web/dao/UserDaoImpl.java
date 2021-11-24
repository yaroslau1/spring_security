package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List getAllUsers() {
        List<User> userList = entityManager.createQuery(
                "SELECT u FROM User u").getResultList();
        return userList;
    }

    @Override
    public User getUserById(Long id) {
        User movie = entityManager.find(User.class, new Long(id));
        entityManager.detach(movie);
        return movie;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        User user = entityManager.find(User.class, new Long(id));
        entityManager.remove(user);
    }

    @Override
    public User findUserByName(String name) {
        User user = entityManager.createQuery("SELECT u from User u WHERE u.name = :name", User.class).
                setParameter("name", name).getSingleResult();
        System.out.println(user);
        return user;
    }
}
