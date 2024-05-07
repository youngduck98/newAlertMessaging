package org.example.newalertmessaging.Service.userDetailedService;

import org.example.newalertmessaging.repository.StudentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailedService implements UserDetailsService {

    private final StudentJpaRepository studentJpaRepository;

    public CustomUserDetailedService(StudentJpaRepository studentJpaRepository) {
        this.studentJpaRepository = studentJpaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
