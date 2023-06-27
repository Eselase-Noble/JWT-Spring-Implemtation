package com.nobleson.JWTSPRINGBOOT.models;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Author: Nobleson
 * Version: 1.0.0
 * Date: 27/06/2023
 */

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class AppUsers implements UserDetails {

    @Id
    @Column(name = "UserID")
    private Integer userID;
    @Column(name="Surname")
    private String surname;
    @Column(name = "First Name")
    private String firstName;
    @Column(name = "Email")
    private String email;
    @Column(name = "Password")
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    //Returns the list of the roles
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
