package com.nobleson.JWTSPRINGBOOT.repository;

import com.nobleson.JWTSPRINGBOOT.models.AppUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUsers, Integer> {

    Optional<AppUsers> findAppUsersByEmail(String email);
}
