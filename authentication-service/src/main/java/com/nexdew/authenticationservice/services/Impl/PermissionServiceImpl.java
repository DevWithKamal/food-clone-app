package com.nexdew.authenticationservice.services.Impl;


import com.nexdew.authenticationservice.entities.Permissions;
import com.nexdew.authenticationservice.repository.PermissionRepository;
import com.nexdew.authenticationservice.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;
    @Override
    public Permissions createPermissions(Permissions permissions) {
        return permissionRepository.save(permissions);
    }
}
