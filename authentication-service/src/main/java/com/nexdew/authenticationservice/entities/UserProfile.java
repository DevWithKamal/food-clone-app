package com.nexdew.authenticationservice.entities;

import com.nexdew.authenticationservice.common.entity.BaseEntity;
import com.nexdew.authenticationservice.enumeration.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile  extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private  String contactNo;
    @OneToOne
    private  User user;

    private String email;

    private Date dateOfBirth;

    private  Date anniversary;
    @Enumerated(EnumType.STRING)
    private Gender gender;


}
