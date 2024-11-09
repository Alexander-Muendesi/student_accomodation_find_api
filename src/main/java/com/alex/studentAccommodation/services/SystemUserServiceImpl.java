package com.alex.studentAccommodation.services;

import com.alex.studentAccommodation.daoRepositories.SystemUserRepository;
import com.alex.studentAccommodation.entities.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SystemUserServiceImpl implements SystemUserService, UserDetailsService {
    @Autowired
    private SystemUserRepository systemUserRepository;

    @Override
    @Transactional
    public SystemUser registerUser(SystemUser user) {
        return systemUserRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<SystemUser> user = systemUserRepository.findByUsername(username);

        if(user.isPresent())
            return user.get();
        else
            throw new UsernameNotFoundException("User not found: " + username);
    }
}
