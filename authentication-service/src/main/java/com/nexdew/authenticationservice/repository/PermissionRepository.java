package com.nexdew.authenticationservice.repository;


import com.nexdew.authenticationservice.common.repository.BaseRepository;
import com.nexdew.authenticationservice.entities.Permissions;

import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PermissionRepository extends BaseRepository<Permissions, UUID> {
}
