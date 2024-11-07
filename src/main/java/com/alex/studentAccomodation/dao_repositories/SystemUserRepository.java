package com.alex.studentAccomodation.dao_repositories;

import com.alex.studentAccomodation.entities.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SystemUserRepository extends JpaRepository<SystemUser, UUID> {

}
