package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;

import java.util.Set;

public interface RoleRepository {
    Set<Role> getAllRoles();
}
