package com.learn.usermanagement.getroleapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public String getRoleNameById(int id) {
        Role role = roleRepository.findById(id).orElse(null);
        if (role != null) {
            return role.getRole_name();
        } else {
            return "Invalid ID";
        }
    }
}


