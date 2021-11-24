package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.RoleRepository;
import web.model.Role;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Set<Role> getAllRoles() {
        return roleRepository.getAllRoles();
    }
}
