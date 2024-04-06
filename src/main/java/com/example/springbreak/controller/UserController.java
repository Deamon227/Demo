package com.example.springbreak.controller;

import com.example.springbreak.model.dto.UserDTO;
import com.example.springbreak.model.entity.User;
import com.example.springbreak.service.user.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private AppUserService userService;
    @GetMapping("/{id}")
    public ResponseEntity<Iterable<UserDTO>> getUserByRole(@PathVariable Long id){
        Iterable<UserDTO> u = userService.getUserPerRole(id);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

}
