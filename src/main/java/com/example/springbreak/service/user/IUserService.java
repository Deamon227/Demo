package com.example.springbreak.service.user;

import com.example.springbreak.model.dto.UserDTO;
import com.example.springbreak.model.entity.User;
import com.example.springbreak.service.IGeneratedService;
import jakarta.persistence.Id;
import org.springframework.data.repository.query.Param;

public interface IUserService extends IGeneratedService<User> {
    Iterable<UserDTO> getUserPerRole(Long id);
}
