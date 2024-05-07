package com.example.springbreak.service.role;

import com.example.springbreak.model.dto.CountUserPerRole;
import com.example.springbreak.model.dto.RoleCountDTO;
import com.example.springbreak.model.dto.RoleDTO;
import com.example.springbreak.model.dto.UserDTO;
import com.example.springbreak.model.entity.Role;
import com.example.springbreak.service.IGeneratedService;
import org.springframework.stereotype.Service;

@Service
public interface IRoleService extends IGeneratedService<Role> {
    Iterable<CountUserPerRole> countRoleByUser();
    Iterable<UserDTO> getUserByRoleId(Long id);
    Iterable<RoleDTO> mapperUserDTO();
}
