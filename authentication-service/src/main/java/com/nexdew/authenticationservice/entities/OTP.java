package com.nexdew.authenticationservice.entities;

import com.nexdew.authenticationservice.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OTP  extends BaseEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID otpId;

    private  String otp;

    private  String contactNo;

}
