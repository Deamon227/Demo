package com.example.springbreak.service.role;

import com.example.springbreak.model.dto.CountUserPerRole;
import com.example.springbreak.model.dto.RoleCountDTO;
import com.example.springbreak.model.dto.RoleDTO;
import com.example.springbreak.model.dto.UserDTO;
import com.example.springbreak.model.entity.Role;
import com.example.springbreak.repository.IRoleRepository;
import com.example.springbreak.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class RoleService implements IRoleService{
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private IUserRepository userRepository;
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

    @Override
    public Iterable<UserDTO> getUserByRoleId(Long id) {
        return roleRepository.getUserByRoleId(id);
    }

    @Override
    public Iterable<RoleDTO> mapperUserDTO() {
        Iterable<Role> r = roleRepository.findAll();
        List<RoleDTO> listR = new ArrayList<>();
        for(Role rn : r){
            Long id = rn.getId();
            String name = rn.getName();
            Iterable<UserDTO> userDTO = getUserByRoleId(id);
            RoleDTO rd = new RoleDTO(id, name, userDTO);
            listR.add(rd);
        }
        return listR;
    }

}
