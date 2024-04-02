package com.nexdew.authenticationservice.repository;

import com.nexdew.authenticationservice.common.repository.BaseRepository;
import com.nexdew.authenticationservice.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface RoleRepository extends BaseRepository<Role, UUID> {
}
