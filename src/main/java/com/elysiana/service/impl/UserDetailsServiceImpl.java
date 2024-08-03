package com.elysiana.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.elysiana.entities.User;
import com.elysiana.repository.UserRepository;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        Collection<? extends GrantedAuthority> authorities = Collections
                .singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole()));

        return new UserDetailsImpl(
                user.getUserId(),
                user.getName(),
                user.getEmail(),
                user.getContact(),
                user.getPassword(),
                authorities
        );
    }
}
