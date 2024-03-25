package com.app.service;

import com.app.persistence.entities.UserEntity;
import com.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user= repository.findUserEntityByUserName(username)
                .orElseThrow(()-> new UsernameNotFoundException("usuario no encontrado"));

        List<SimpleGrantedAuthority> authorityList= new ArrayList<>();
        user.getRoles().forEach(role->authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleEnum().name()))));
        user.getRoles().stream().flatMap(role->role.getPermissionEntities().stream()).forEach(permission-> authorityList.add(new SimpleGrantedAuthority(permission.getName())));

        return new User(
                user.getUserName(),
                user.getPassword(),
                user.isEnabled(),
                user.isAccountNoExpired(),
                user.isCredentialsNoExpired(),
                user.isAccountNoLocked(),
                authorityList
        );
    }
}
