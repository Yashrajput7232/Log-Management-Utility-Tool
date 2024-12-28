package com.project.logmanagementutilitytool.Service;

import com.project.logmanagementutilitytool.Repository.UserRepository;
import com.project.logmanagementutilitytool.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> authUser = userRepository.findByUsername(username);
        if (authUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        else {
            System.out.println(authUser);
            return User.builder()
                    .username(authUser.get().getUsername())
                    .password(authUser.get().getPassword()) // password is already encoded
                    .roles(authUser.get().getRoles().stream().map(role -> role.getRoleName()).toArray(String[]::new))
                    .build();
//                    new User(authUser.get().getUsername(), authUser.get().getPassword(), null);
        }

    }
}

