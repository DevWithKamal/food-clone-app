package com.nexdew.authenticationservice.repository;


import com.nexdew.authenticationservice.common.repository.BaseRepository;
import com.nexdew.authenticationservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends BaseRepository<User, UUID> {



    Optional<User> findUserByContactNo(String contactNo);
}
