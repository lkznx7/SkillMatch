package com.lkznx7.userservice.infrastructure.services.tools;

import com.lkznx7.userservice.infrastructure.repository.UserServiceRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsImpl implements UserDetailsService {

    UserServiceRepository userServiceRepository;
    public UserDetailsImpl(UserServiceRepository userServiceRepository) {
        this.userServiceRepository = userServiceRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userServiceRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
