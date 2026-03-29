package com.bus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
// find user by email — used during login
Optional<User> findByEmail(String email);
// check if email already exists — used during register
boolean existsByEmail(String email);
}