package com.sasha.store.clothesservice.dao.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "_user_app")
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserApp implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String password;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private Date registerDate;
    private Boolean isLock;
    private Boolean hasExpired;
    private Boolean isEnabled;
    private Boolean isCredentialsNonExpired;
    private Boolean isAccountNonExpired;
    private Boolean isAccountNonLocked;
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of( new SimpleGrantedAuthority(role.name()));
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
