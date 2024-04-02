package com.nexdew.authenticationservice.controller;



import com.nexdew.authenticationservice.entities.Permissions;
import com.nexdew.authenticationservice.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;
    @PostMapping("/createPermission")
    public ResponseEntity<Permissions> createPermission(@RequestBody Permissions permissions)
    {
        return  ResponseEntity.ok(permissionService.createPermissions(permissions));
    }
}
