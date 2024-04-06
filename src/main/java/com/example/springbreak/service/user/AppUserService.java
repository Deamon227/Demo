package com.example.springbreak.service.user;

import com.example.springbreak.model.dto.UserDTO;
import com.example.springbreak.model.entity.User;
import com.example.springbreak.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;
    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Iterable<UserDTO> getUserPerRole(Long id) {
        return userRepository.getUserPerRole(id);
    }
}
