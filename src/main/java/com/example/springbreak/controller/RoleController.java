package com.example.springbreak.controller;

import com.example.springbreak.model.dto.CountUserPerRole;
import com.example.springbreak.service.role.RoleService;
import com.example.springbreak.service.type.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping("")
    public ResponseEntity<Iterable<CountUserPerRole>> countUser(){
        Iterable<CountUserPerRole> c = roleService.countRoleByUser();
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
}
