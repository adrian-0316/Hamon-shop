package com.example.jamonshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<com.jamonshop.entity.User, Long> {
    Optional<com.jamonshop.entity.User> findByUsername(String username);
}
