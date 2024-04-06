package com.example.springbreak.service.role;

import com.example.springbreak.model.dto.CountUserPerRole;
import com.example.springbreak.model.entity.Role;
import com.example.springbreak.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleService implements IRoleService{
    @Autowired
    private IRoleRepository roleRepository;
    @Override
    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Iterable<CountUserPerRole> countRoleByUser() {
        return roleRepository.countRoleByUser();
    }
}
