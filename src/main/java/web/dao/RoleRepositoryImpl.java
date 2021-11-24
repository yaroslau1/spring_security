package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Set<Role> getAllRoles() {
        List<Role> rolesList = entityManager.createQuery(
                "SELECT r FROM Role r").getResultList();
        return rolesList.stream().collect(Collectors.toSet());
    }
}
