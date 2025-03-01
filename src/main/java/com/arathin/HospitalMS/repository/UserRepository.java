package com.arathin.HospitalMS.repository;

import com.arathin.HospitalMS.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
