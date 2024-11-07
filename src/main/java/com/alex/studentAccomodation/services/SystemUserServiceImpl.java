package com.alex.studentAccomodation.services;

import com.alex.studentAccomodation.dao_repositories.SystemUserRepository;
import com.alex.studentAccomodation.entities.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemUserServiceImpl implements SystemUserService{
    @Autowired
    private SystemUserRepository systemUserRepository;

    @Override
    public SystemUser registerUser(SystemUser user) {
        return systemUserRepository.save(user);
    }
}
