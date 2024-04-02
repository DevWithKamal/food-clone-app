package com.nexdew.authenticationservice.entities;

import com.nexdew.authenticationservice.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID )
    private UUID id;



    private  String contactNo;

    private  String otp;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    @Cascade(CascadeType.ALL)
    private Role role;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Permissions> permissions = role.getPermissions();
        return permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return otp;
    }

    @Override
    public String getUsername() {
        return contactNo;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
