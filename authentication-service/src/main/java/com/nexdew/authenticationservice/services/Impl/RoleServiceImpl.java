package com.nexdew.authenticationservice.services.Impl;


import com.nexdew.authenticationservice.entities.Role;
import com.nexdew.authenticationservice.repository.RoleRepository;
import com.nexdew.authenticationservice.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }
}
